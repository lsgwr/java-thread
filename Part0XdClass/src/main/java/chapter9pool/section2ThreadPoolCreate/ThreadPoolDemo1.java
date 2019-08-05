package main.java.chapter10pool;

/***********************************************************
 * @note      : 线程池的基本使用，现象是只有10个线程池的池子
 * @author    : l00379880 梁山广
 * @version   : V1.0 at 2019/8/5 14:20
 ***********************************************************/

import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池Demo
 */
public class ThreadPoolDemo1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        LinkedBlockingQueue<Runnable> objects = new LinkedBlockingQueue<>();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20, 3L, TimeUnit.SECONDS, objects);
        for (int i = 0; i < 100; i++) {
            threadPoolExecutor.submit(() -> {
                System.out.println(Thread.currentThread().getName());
            });
        }
    }
}

