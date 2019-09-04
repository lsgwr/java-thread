package com.huawei.l00379880.mythread.Chapter07JUCMore.Section1And2FutureTask;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/***********************************************************
 * @note      : Future基本使用案例，Callable返回多线程执行结果
 * @author    : l00379880 梁山广
 * @version   : V1.0 at 2019/9/4 10:26
 ***********************************************************/
@Slf4j
public class FutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        // 创建callable任务，使用Future接收任务执行的结果、
        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("do something in callable");
                Thread.sleep(5000);
                return "Done";
            }
        });
        System.out.println("Do something in main");
        Thread.sleep(1000);
        // 获取执行结果,get()方法是阻塞的，阻塞等待获取任务执行结果
        System.out.println("Future执行结果：" + future.get());
        executorService.shutdown();
    }
}
