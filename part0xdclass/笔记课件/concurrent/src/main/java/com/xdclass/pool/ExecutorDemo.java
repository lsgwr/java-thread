package com.xdclass.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Executor 框架Demo
 */
public class ExecutorDemo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ExecutorService executorService1 = Executors.newFixedThreadPool(2);
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        ExecutorService executorService2 = Executors.newWorkStealingPool();
        ExecutorService executorService3 = Executors.newSingleThreadExecutor();
        ScheduledExecutorService scheduledExecutorService1 = Executors.newSingleThreadScheduledExecutor();

        executorService.submit(() -> {
            System.out.println(Thread.currentThread().getName());
        });
    }
    

}
