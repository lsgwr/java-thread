# 第06章 JUC之AQS

> Java并发包(java.util.concurrent JUC)中提供了很多并发工具，这其中，很多我们耳熟能详的并发工具，譬如ReentrangLock、Semaphore，而它们的实现都用到了一个共同的基类--AbstractQueuedSynchronizer(抽象队列同步器)，简称AQS

包路径为：`java.util.concurrent.locks.AbstractQueuedSynchronizer`

## 6.1 AQS原理和代码介绍

### 总体介绍

AbstractQueuedSynchronizer底层数据结构是一个双向链表，属于队列的一种实现,代码流程如下：

![AQS的代码实现](images/Chapter06AQS/AQS_code_structure.jpg)

+ sync queue：同步队列，其中head节点主要负责后面的调度
+ Condition queue：单向链表，不是必须的，只有程序中使用到Condition的时候才会存在，可能会有多个Condition queue

AQS是JDK1.5开始提供的

+ 是使用基于Node实现的FIFO等待队列的阻塞锁和相关的同步器的一个同步框架，
+ 使用一个int类型的volatile变量(命名为state)来维护同步状态，通过内置的FIFO队列来完成资源获取线程的排队工作
+ 使用方法是继承
+ 子类通过继承并通过实现它的方法管理其状态{acquire和release}的方法操纵其状态
+ 可以同时实现排他锁和共享锁模式(独占exclusive、共享shared)

AbstractQueuedSynchronizer中对state的操作是原子的，且不能被继承。所有的同步机制的实现均依赖于对改变量的原子操作。为了实现不同的同步机制，我们需要创建一个非共有的(non-public internal)扩展(extends)了AQS类的内部辅助类来实现相应的同步逻辑,以java.util.concurrent.locks.ReentrantReadWriteLoc为例，其252行开始如下代码：

```java
/**
 * Synchronization implementation for ReentrantReadWriteLock.
 * Subclassed into fair and nonfair versions.
 */
abstract static class Sync extends AbstractQueuedSynchronizer {
  ......
  
```

AbstractQueuedSynchronizer并不实现任何同步接口，它提供了一些可以被具体实现类直接调用的一些原子操作方法来重写相应的同步逻辑。AQS同时提供了`独占模式(exclusive)`和`共享模式(shared)`两种不同的同步逻辑。一般情况下，子类只需要根据需求实现其中一种模式，当然也有同时实现两种模式的同步类，如ReadWriteLock

使用AQS能简单且高效地构造出应用广泛的大量的同步器，比如我们提到的ReentrantLock，Semaphore，其他的诸如`ReentrantReadWriteLock`、`SynchronousQueue`、`FutureTask`等等皆是基于AQS的。

当然，我们自己也能利用AQS非常轻松容易地构造出符合我们自己需求的同步器，由此可知`AQS是Java并发包中最为核心的一个基类`。


### 关于AQS里的state状态：

我们提到了AbstractQueuedSynchronizer维护了一个volatile int类型的变量，命名为state，用于表示当前同步状态。volatile虽然不能保证操作的原子性，但是保证了当前变量state的可见性。state的访问方式有三种:

```java
getState()
setState()
compareAndSetState()
```

这三种操作均是原子操作，其中compareAndSetState的实现依赖于Unsafe的compareAndSwapInt()方法。

### 关于自定义资源共享方式：

AQS支持两种资源共享方式：Exclusive(独占，只有一个线程能执行，如ReentrantLock)和Share(共享，多个线程可同时执行，如Semaphore/CountDownLatch)。这样方便使用者实现不同类型的同步组件，独占式如ReentrantLock，共享式如Semaphore，CountDownLatch，组合式的如ReentrantReadWriteLock。总之，AQS为使用提供了底层支撑，如何组装实现，使用者可以自由发挥。

### 关于同步器设计：

同步器的设计是基于模板方法模式的，一般的使用方式是这样：

+ 使用者继承AbstractQueuedSynchronizer并重写指定的方法。（这些重写方法很简单，无非是对于共享资源state的获取和释放）
+ 将AQS组合在自定义同步组件的实现中，并调用其模板方法，而这些模板方法会调用使用者重写的方法。这其实是模板方法模式的一个很经典的应用。

不同的自定义同步器争用共享资源的方式也不同。自定义同步器在实现时只需要实现共享资源state的获取与释放方式即可，至于具体线程等待队列的维护（如获取资源失败入队/唤醒出队等），AQS已经在底层实现好了。自定义同步器实现时主要实现以下几种方法：

```java
protected boolean isHeldExclusively()    // 该线程是否正在独占资源。只有用到condition才需要去实现它。
protected boolean tryAcquire(int)        // 独占方式。尝试获取资源，成功则返回true，失败则返回false。
protected boolean tryRelease(int)        // 独占方式。尝试释放资源，成功则返回true，失败则返回false。
protected int tryAcquireShared(int)  // 共享方式。尝试获取资源。负数表示失败；0表示成功，但没有剩余可用资源；正数表示成功，且有剩余资源。
protected boolean tryReleaseShared(int)  // 共享方式。尝试释放资源，如果释放后允许唤醒后续等待结点返回true，否则返回false。
```

### 如何使用：

首先，我们需要去继承`AbstractQueuedSynchronizer`这个类，然后我们根据我们的需求去重写相应的方法，比如
+ 要实现一个独占锁，那就去重写tryAcquire，tryRelease方法
+ 要实现共享锁，就去重写tryAcquireShared，tryReleaseShared
+ 最后，在我们的组件中调用AQS中的模板方法就可以了，而这些模板方法是会调用到我们之前重写的那些方法的。

也就是说，我们只需要很小的工作量就可以实现自己的同步组件，重写的那些方法，仅仅是一些简单的对于共享资源state的获取和释放操作，至于像是获取资源失败，线程需要阻塞之类的操作，自然是AQS帮我们完成了。

### 具体实现的思路：

+ 首先AQS内部维护了一个CLH队列，来管理锁
+ 线程尝试获取锁，如果获取失败，则将等待信息等包装成一个Node结点，加入到同步队列Sync queue里不断重新尝试获取锁（当前结点为head的直接后继才会尝试），如果获取失败，则会阻塞自己，直到被唤醒
+ 当持有锁的线程释放锁的时候，会唤醒队列中的后继线程

### 设计思想：

对于使用者来讲，我们无需关心获取资源失败，线程排队，线程阻塞/唤醒等一系列复杂的实现，这些都在AQS中为我们处理好了。我们只需要负责好自己的那个环节就好，也就是获取/释放共享资源state的姿势。很经典的模板方法设计模式的应用，AQS为我们定义好顶级逻辑的骨架，并提取出公用的线程入队列/出队列，阻塞/唤醒等一系列复杂逻辑的实现，将部分简单的可由使用者决定的操作逻辑延迟到子类中去实现即可。

### 基于AQS的同步组件：

+ CountDownLatch
+ Semaphore
+ CyclicBarrier
+ ReentrantLock
+ Condition
+ FutureTask

### AQS小结：

+ 使用Node实现FIFO队列，可以用于构建锁或者其他同步装置的基础框架
+ 利用了一个int类型表示状态，有一个state的成员变量，表示获取锁的线程数（0没有线程获取锁，1有线程获取锁，大于1表示重入锁的数量），和一个同步组件ReentrantLock。状态信息通过procted级别的getState，setState，compareAndSetState进行操作
+ 使用方法是继承，然后复写AQS中的方法，基于模板方法模式
+ 子类通过继承并通过实现它的方法管理其状态{acquire和release}的方法操作状态
+ 可以同时实现排它锁和共享锁的模式（独占、共享）

## 5.2 CountDownLatch

### 基本原理

CountDownLatch是一个同步工具类，它允许`一个或多个线程一直等待`，直到其他线程执行完后再执行。例如，应用程序的主线程希望在负责启动框架服务的线程已经启动所有框架服务之后执行。

CountDownLatch是通过一个计数器来实现的，计数器的初始化值为线程的数量。每当一个线程完成了自己的任务后，计数器的值就相应得减1。当计数器到达0时，表示所有的线程都已完成任务，然后在闭锁上等待的线程就可以恢复执行任务。

![CountDownLatch示意图](images/Chapter02Prepare/CountDownLatch.jpg)

CountDownLatch的构造函数源码如下：

```java
/**
 * Constructs a {@code CountDownLatch} initialized with the given count.
 *
 * @param count the number of times {@link #countDown} must be invoked
 *        before threads can pass through {@link #await}
 * @throws IllegalArgumentException if {@code count} is negative
 */
public CountDownLatch(int count) {
    if (count < 0) throw new IllegalArgumentException("count < 0");
    this.sync = new Sync(count);
}
```

计数器count是闭锁需要等待的线程数量，只能被设置一次，且CountDownLatch没有提供任何机制去重新设置计数器count。

与CountDownLatch的第一次交互是主线程等待其他线程。主线程必须在启动其他线程后立即调用CountDownLatch.await()方法。这样主线程的操作就会在这个方法上阻塞，直到其他线程完成各自的任务。

其他N个线程必须引用CountDownLatch闭锁对象，因为它们需要通知CountDownLatch对象，它们各自完成了任务；这种通知机制是通过CountDownLatch.countDown()方法来完成的；每调用一次，count的值就减1，因此当N个线程都调用这个方法，count的值就等于0，然后主线程就可以通过await()方法，恢复执行自己的任务。

注：该计数器的操作是原子性的

### CountDownLatch使用场景：

+ 实现最大的并行性：有时我们想同时启动多个线程，实现最大程度的并行性。例如，我们想测试一个单例类。如果我们创建一个初始计数器为1的CountDownLatch，并让其他所有线程都在这个锁上等待，只需要调用一次countDown()方法就可以让其他所有等待的线程同时恢复执行。
+ 开始执行前等待N个线程完成各自任务：例如应用程序启动类要确保在处理用户请求前，所有N个外部系统都已经启动和运行了。
+ 死锁检测：一个非常方便的使用场景是你用N个线程去访问共享资源，在每个测试阶段线程数量不同，并尝试产生死锁。

### 使用示例

#### 1.基本用法：

```java
@Slf4j
public class CountDownLatchExample1 {
    private final static int THREAD_COUNT = 200;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        final CountDownLatch countDownLatch = new CountDownLatch(THREAD_COUNT);

        for (int i = 0; i < THREAD_COUNT; i++) {
            final int threadNum = i;
            exec.execute(() -> {
                try {
                    test(threadNum);
                } catch (InterruptedException e) {
                    log.error("", e);
                } finally {
                    // 为防止出现异常，放在finally更保险一些
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        log.info("finish");
        exec.shutdown();
    }

    private static void test(int threadNum) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(100);
        log.info("{}", threadNum);
        TimeUnit.MILLISECONDS.sleep(100);
    }
}
```

#### 2.超时结束

比如有多个线程完成一个任务，但是这个任务只想给它一个指定的时间，超过这个任务就不继续等待了，完成多少算多少：

```java
// 等待指定的时间 参数1：等待时间，参数2：时间单位
countDownLatch.await(10, TimeUnit.MILLISECONDS);
```

关于CountDownLatch的其他例子可以参考另一篇文章：

[CountDownLatch类的使用](https://blog.51cto.com/zero01/2108173)
