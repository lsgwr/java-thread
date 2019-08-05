package main.java.chapter10pool;

/***********************************************************
 * @note      : LinkedBlockingQueue的初始化参数会导致异常
 * @author    : l00379880 梁山广
 * @version   : V1.0 at 2019/8/5 14:20
 ***********************************************************/

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池Demo
 */
public class ThreadPoolDemo2 {

    public static void main(String[] args) {
        // 虽然会抛出异常，但是仍然成功创建了20个线程的线程池
        LinkedBlockingQueue<Runnable> objects = new LinkedBlockingQueue<>(20);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20, 3L, TimeUnit.SECONDS, objects);
        for (int i = 0; i < 100; i++) {
            threadPoolExecutor.submit(() -> {
                System.out.println(Thread.currentThread().getName());
            });
        }
    }
}

