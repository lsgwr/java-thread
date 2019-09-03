/***********************************************************
 * @Description : ReentrantLock的基本使用
 * @author      : 梁山广(Liang Shan Guang)
 * @date        : 2019/9/3 23:25
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package com.huawei.l00379880.mythread.Chapter06AQS.Section5ReentrantLock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Example1 {
    /**
     * 请求总数
     */
    public static int clientTotal = 5000;

    /**
     * 同时并发的线程数
     */
    public static int threadTotal = 200;

    /**
     * 计数
     */
    private static int count;

    /**
     * 锁对象，默认是使用非公平锁，可以传入true和false来决定使用公平所还是非公平锁
     */
    private final static Lock LOCK = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        Semaphore semaphore = new Semaphore(threadTotal);
        CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            exec.execute(() -> {
                try {
                    semaphore.acquire();
                    Example1.add();
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        exec.shutdown();
        System.out.println("count=" + count);
    }

    private static void add() {
        LOCK.lock();
        try {
            count++;
        } finally {
            LOCK.unlock();
        }
    }
}
