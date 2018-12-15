package com.xdclass.pool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池Demo
 */
public class ThreadPoolDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        LinkedBlockingQueue<Runnable> objects = new LinkedBlockingQueue<>(20);

//        for (int i = 0; i <100 ; i++) {
//            objects.put(()->{
//                System.out.println(Thread.currentThread().getName());
//            });
//        }


        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10,20,3L,TimeUnit.SECONDS,objects,new CustomPolicy());
        threadPoolExecutor.prestartAllCoreThreads();
//        Future<String> submit = null;
        for (int i = 0; i < 50; i++) {
            threadPoolExecutor.submit(()->{
                try {
                    Thread.sleep(2000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(threadPoolExecutor.getActiveCount());
            });
        }
//
//        for (int i = 0; i < 100; i++) {
//            System.out.println(submit.get());
//        }
    }
}
