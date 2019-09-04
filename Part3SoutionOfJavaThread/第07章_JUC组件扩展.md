# 第7章 JUC组件扩展

## 7.1 FutureTask

### 简介

在Java中一般通过继承Thread类或者实现Runnable接口这两种方式来创建线程，但是这两种方式都有个缺陷，就是不能在执行完成后获取执行的结果，因此Java 1.5之后提供了Callable和Future接口，通过它们就可以在任务执行完毕之后得到任务的执行结果。

而FutureTask则是J.U.C中的类，但不是AQS的子类，FutureTask是一个可删除的异步计算类。这个类提供了Future接口的的基本实现，使用相关方法启动和取消计算，查询计算是否完成，并检索计算结果。只有在计算完成时才能使用get方法检索结果;如果计算尚未完成，get方法将会阻塞。一旦计算完成，计算就不能重新启动或取消(除非使用runAndReset方法调用计算)。

### Runnable、Callable、Future接口对比

+ Runnable是一个接口，在它里面只声明了一个run()方法。由于run()方法返回值为void类型，所以在`执行完任务之后无法返回任何结果`：
  ```java
  public interface Runnable {
      public abstract void run();
  }
  ```
+ Callable接口也只声明了一个方法，这个方法叫做call()。Callable接口定义如下:
  ```java
  public interface Callable<V> {
      /**
       * Computes a result, or throws an exception if unable to do so.
       *
       * @return computed result
       * @throws Exception if unable to compute a result
       */
      V call() throws Exception;
  }
  ```
  > 可以看到Callable是个泛型接口，泛型V就是要call()方法返回的类型。Callable接口和Runnable接口很像，都可以被另外一个线程执行，但是正如前面所说的，Runnable不会返回数据也不能抛出异常。 
+ Future也是一个接口，Future接口`代表异步计算的结果`，通过Future接口提供的方法可以查看异步计算是否执行完成，或者等待执行结果并获取执行结果，同时还可以取消执行。说白了Future就是对于具体的Runnable或者Callable任务的执行结果进行取消、查询是否完成以及获取执行结果。其中执行结果通过get方法获取，该方法会阻塞直到任务返回结果。Future接口的定义如下：
  ```java
  public interface Future<V> {
      boolean cancel(boolean mayInterruptIfRunning);
      boolean isCancelled();
      boolean isDone();
      V get() throws InterruptedException, ExecutionException;
      V get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException;
  }
  ```

### Future接口中的方法介绍

```java
public interface Future<V> {
    boolean cancel(boolean mayInterruptIfRunning);
    boolean isCancelled();
    boolean isDone();
    V get() throws InterruptedException, ExecutionException;
    V get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException;
}
```

+ `boolean cancel(boolean mayInterruptIfRunning);`:cancel()方法用来取消异步任务的执行
  + 如果异步任务已经完成或者已经被取消，或者由于某些原因不能取消，则会返回false。
  + 如果任务还没有被执行，则会返回true并且异步任务不会被执行。
  + 如果任务已经开始执行了但是还没有执行完成
    + 若mayInterruptIfRunning为true，则会立即中断执行任务的线程并返回true
    + 若mayInterruptIfRunning为false，则会返回true且不会中断任务执行线程
+ `boolean isCancelled();`:用于判断任务是否被取消
  + 如果任务在结束(正常执行结束或者执行异常结束)前被取消则返回true
  + 否则返回false。
+ `boolean isDone();`:用于判断任务是否已经完成，
  + 如果完成则返回true，
  + 否则返回false。
  + 需要注意的是：任务执行过程中发生异常、任务被取消也属于任务已完成，也会返回true。
+ `V get();`:用于获取任务执行结果
  + 如果任务`还没完成`则会阻塞等待直到任务执行完成。
  + 如果任务`被取消`则会抛出CancellationException异常
  + 如果任务`执行过程发生异常`则会抛出ExecutionException异常
  + 如果`阻塞等待过程中被中断`则会抛出InterruptedException异常
+ `V get(long timeout, TimeUnit unit);`:带超时时间的get()版本，如果阻塞等待过程中超时则会抛出TimeoutException异常。

综上，Future接口提供了三种功能：
+ 判断任务是否完成
+ 中断任务
+ 获取任务执行结果

### Future与FutureTask的关系

因为Future只是一个接口，所以是无法直接用来创建对象使用的，因此就有了下面的FutureTask。FutureTask的父类是RunnableFuture，而RunnableFuture则继承了Runnable和Future这两个接口。所以由此可知，FutureTask最终也属于是Callable类型的任务。如果往FutureTask的构造函数传入Runnable的话，也会被转换成Callable类型。

FutureTask继承图如下：

![FutureTask继承图](images/Chapter07JUCMore/FutureTask继承图.png)

可以看到，FutureTask实现了RunnableFuture接口，则RunnableFuture接口继承了Runnable接口和Future接口，所以FutureTask既能当做一个Runnable直接被Thread执行，也能作为Future用来得到Callable的计算结果。

### FutureTask的使用场景

假设有一个很费时的逻辑需要计算，并且需要返回计算的结果，但这个结果又不是马上需要的。那么这时就可以使用FutureTask，用另外一个线程去进行计算，而当前线程在得到这个计算结果之前，就可以去执行其他的操作，等到需要这个结果时再通过Future得到即可。

### FutureTask的构造器

FutureTask有两个构造器，支持传入Callable和Runnable类型，在使用 Runnable 时，需要多指定一个返回结果类型：

```java
public FutureTask(Callable<V> callable) {
    if (callable == null)
        throw new NullPointerException();
    this.callable = callable;
    this.state = NEW;       // ensure visibility of callable
}

public FutureTask(Runnable runnable, V result) {
    this.callable = Executors.callable(runnable, result);
    this.state = NEW;       // ensure visibility of callable
}
```

### 使用示例

#### 1.Future基本使用示例

```java
@Slf4j
public class FutureExample {

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        // 使用lambda创建callable任务，使用Future接收任务执行的结果
        Future<String> future = executorService.submit(() -> {
            log.info("do something in callable");
            Thread.sleep(5000);

            return "Done";
        });

        log.info("do something in main");
        Thread.sleep(1000);
        // 获取执行结果
        String result = future.get();
        log.info("result: {}", result);
        executorService.shutdown();
    }
}
```

#### 2.FutureTask基本使用示例：

```java
@Slf4j
public class FutureTaskExample {

    public static void main(String[] args) throws Exception {
        // 构建FutureTask实例，使用lambda创建callable任务
        FutureTask<String> futureTask = new FutureTask<>(() -> {
            log.info("do something in callable");
            Thread.sleep(5000);

            return "Done";
        });

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(futureTask);

        log.info("do something in main");
        Thread.sleep(1000);
        // 获取执行结果
        String result = futureTask.get();
        log.info("result: {}", result);
        executorService.shutdown();
    }
}
```

从以上两个示例可以看到，Future和FutureTask的使用方式是很相似的，毕竟FutureTask就是Future的一个实现。
