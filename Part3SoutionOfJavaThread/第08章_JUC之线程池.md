# 第08章 JUC之线程池

## 线程池地重要性和使用场景

平时有接触过多线程开发的小伙伴们应该都或多或少都有了解、使用过线程池，而《阿里巴巴 Java 手册》里也有一条规范：

![阿里巴巴 Java 手册线程池规范](https://s1.51cto.com/images/blog/201810/20/af6f693eabfcc3ad4a47aa97339be0f9.png)

由此可见线程池的重要性，线程池对于限制应用程序中同一时刻运行的线程数很有用。因为每启动一个新线程都会有相应的性能开销，每个线程都需要给栈分配一些内存等等。

我们可以把并发执行的任务传递给一个线程池，来替代为每个并发执行的任务都启动一个新的线程。只要池里有空闲的线程，任务就会分配给一个线程执行。在线程池的内部，任务被插入一个阻塞队列（Blocking Queue ），线程池里的线程会去取这个队列里的任务。当一个新任务插入队列时，一个空闲线程就会成功的从队列中取出任务并且执行它。

线程池经常应用在多线程服务器上。每个通过网络到达服务器的连接都被包装成一个任务并且传递给线程池。线程池的线程会并发的处理连接上的请求。

## 使用线程池有以下几个目的

+ 线程是稀缺资源，不能频繁的创建。应当将其放入一个池子中，可以给其他任务进行复用，减少对象创建、消亡的开销，性能好
+ 解耦作用；线程的创建于执行完全分开，方便维护。
+ 线程池可有效控制最大并发线程数，提高系统资源利用率，同时可以避免过多资源竞争，避免阻塞
+ 线程池可提供定时执行、定期执行、单线程以及并发数控制等功能

## 直接new Thread的弊端

+ 每次new Thread 新建对象，性能差
+ 线程缺乏统一管理，可能无限制的新建线程，相互竞争，常常会出现占用过多的系统资源导致死机或者发生OOM（out of memory 内存溢出），这种问题的原因不是因为单纯的new一个Thread，而是可能因为程序的bug或者设计上的缺陷导致不断new Thread造成的。
+ 缺少更多功能，如更多执行、定期执行、线程中断等

## 线程池原理

谈到线程池就会想到池化技术，其中最核心的思想就是把宝贵的资源放到一个池子中；每次使用都从里面获取，用完之后又放回池子供其他人使用，有点吃大锅饭的意思。

### 线程池类图

![线程池类图](https://s1.51cto.com/images/blog/201810/20/096d98da5f6ad008ee58067ebd9bf02e.png)

在上边的类图中，最上层就是Executor框架，它是一个根据一组执行策略的调用调度执行和控制异步任务的框架，目的是提供一种将任务提交与任务如何运行分离开的机制。它包含了三个executor接口：

+ `Executor`：运行新任务的简单接口
+ `ExecutorService`：扩展了Executor，添加了用来管理执行器生命周期和任务生命周期的方法
+ `ScheduledExecutorService`：扩展了ExecutorService，支持Future和定期执行任务

在类图中，我们最常使用的是ThreadPoolExecutor和Executors，这两个类都可以创建线程池，其中ThreadPoolExecutor是可定制化的去创建线程池，而Executors则属于是工具类，该类中已经封装好了一些创建线程池的方法，直接调用相应的方法即可创建线程。

在类图中，我们最常使用的是ThreadPoolExecutor和Executors，这两个类都可以创建线程池，其中ThreadPoolExecutor是可定制化的去创建线程池，而Executors则属于是工具类，该类中已经封装好了一些创建线程池的方法，直接调用相应的方法即可创建线程。

但《阿里巴巴 Java 手册》里有一条规范指明不允许使用Executors创建线程池，具体如下：

![不允许使用Executors创建线程池](https://s1.51cto.com/images/blog/201810/20/94bb13442f93dbe806f8376c7562027f.png)

## 构造函数解析

可以说线程池体系里最为核心的类是ThreadPoolExecutor，也是功能最强的，ThreadPoolExecutor共有四个构造函数，如下：

```java
ThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue);
ThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory)
ThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler);
ThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler);
```

其中最多可传入七个参数，这七个参数配合起来，构成了线程池强大的功能。参数说明：

### 上面四个构造函数的参数解析如下：

+ corePoolSize：核心线程数量
+ maximumPoolSize：线程最大线程数
+ workQueue：阻塞队列，存储等待执行的任务，很重要，会对线程池运行过程产生重大影响
+ keepAliveTime：线程没有任务执行时最多保持多久时间终止（当线程中的线程数量大于corePoolSize的时候，如果这时没有新的任务提交核心线程外的线程不会立即销毁，而是等待，直到等待的时间超过keepAliveTime）
+ unit：keepAliveTime的时间单位
+ threadFactory：线程工厂，用来创建线程，若不设置则使用默认的工厂来创建线程，这样新创建出来的线程会具有相同的优先级，并且是非守护的线程，同时也会设置好名称
+ rejectHandler：当拒绝处理任务时(阻塞队列满)的策略（AbortPolicy默认策略直接抛出异常、CallerRunsPolicy用调用者所在的线程执行任务、DiscardOldestPolicy丢弃队列中最靠前的任务并执行当前任务、DiscardPolicy直接丢弃当前任务）

### 拒绝策略的实现类都在TreadPoolExecutor中：

![拒绝策略的实现类](https://s1.51cto.com/images/blog/201810/20/6516174d307959d57ba03e55eb34e661.png)

### 我们来说一下其中corePoolSize、maximumPoolSize、workQueue 这三个参数的关系：

+ 如果运行的线程数量小于corePoolSize的时候，直接创建新线程来处理任务。即使线程池中的其他线程是空闲的
+ 如果线程池中的线程数量大于corePoolSize且小于maximumPoolSize时，那么只有当workQueue满的时候才创建新的线程去处理任务
+ 如果corePoolSize与maximumPoolSize是相同的，那么创建的线程池大小是固定的。这时如果有新任务提交，且workQueue未满时，就把请求放入workQueue中，等待空闲线程从workQueue取出任务进行处理。
+ 如果需要运行的线程数量大于maximumPoolSize时，并且此时workQueue也满了，那么就使用rejectHandler参数所指定的拒绝策略去进行处理。

### 然后我们来具体介绍一下 workQueue

它是保存待执行任务的一个阻塞队列，当我们提交一个新的任务到线程池后，线程池会根据当前池中正在运行的线程数量来决定该任务的处理方式。处理方式总共有三种：

+ 1、直接切换（SynchronusQueue）
+ 2、×××队列（LinkedBlockingQueue），若使用该队列，那么线程池中能够创建的最大线程数为corePoolSize，这时maximumPoolSize就不会起作用了。当线程池中所有的核心线程都是运行状态的时候，新的任务提交就会放入等待队列中。
+ 3、有界队列（ArrayBlockingQueue），使用该队列可以将线程池中的最大线程数量限制为maximumPoolSize参数所指定的值，这种方式能够降低资源消耗，但是这种方式使得线程池对线程调度变的更困难。因为此时线程池与队列容量都是有限的了，所以想让线程池处理任务的吞吐率达到一个合理的范围，又想使我们的线程调度相对简单，并且还尽可能降低线程池对资源的消耗，那么我们就需要合理的设置corePoolSize和maximumPoolSize这两个参数的值

分配技巧： 如果想降低资源的消耗包括降低cpu使用率、操作系统资源的消耗、上下文切换的开销等等，可以设置一个较大的队列容量和较小的线程池容量，这样会降低线程池处理任务的吞吐量。如果我们提交的任务经常发生阻塞，我们可以考虑调用相关方法调整maximumPoolSize参数的值。如果我们的队列容量较小，通常需要把线程池的容量设置得大一些，这样cpu的使用率相对来说会高一些。但是如果线程池的容量设置的过大，提高任务的数量过多的时候，并发量会增加，那么线程之间的调度就是一个需要考虑的问题，这样反而可能会降低处理任务的吞吐量。

## 线程池状态

