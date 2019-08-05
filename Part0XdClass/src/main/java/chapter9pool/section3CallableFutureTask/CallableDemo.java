package main.java.chapter10pool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/***********************************************************
 * @note      : Callable实现线程的返回值(对比Runnable是没有返回值的，Callable的call的含义也在此)
 *              现象：3s后输出线程的返回值1111
 * @author    : l00379880 梁山广
 * @version   : V1.0 at 2019/8/5 14:31
 ***********************************************************/
public class CallableDemo implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(1000L);
        return "1111";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableDemo callableDemo = new CallableDemo();
        FutureTask<String> stringFutureTask = new FutureTask<>(callableDemo);
        new Thread(stringFutureTask).start();
        // 打印线程的返回值:1s后输出1111
        System.out.println(stringFutureTask.get());
    }
}
