package com.huawei.l00379880.mythread.Chapter06AQS.Section3Semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/***********************************************************
 * @note      : emaphore可以用于做流量控制，tryAcquire()尝试获取许可证并设置超时时间
 * @author    : l00379880 梁山广
 * @version   : V1.0 at 2019/9/3 20:11
 ***********************************************************/
public class Example4 {
    /**
     * 启动200个线程进行并发读写
     */
    private final static int THREAD_COUNT = 200;

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        // 允许10个线程获取许可证，只有10个数据库连接
        final Semaphore semaphore = new Semaphore(10);

        for (int i = 0; i < THREAD_COUNT; i++) {
            final int threadNum = i;
            exec.execute(() -> {
                // 尝试获取一个许可，若没有获取到许可的线程就会被抛弃，而不是阻塞
                try {
                    if (semaphore.tryAcquire(1, TimeUnit.SECONDS)) {
                        System.out.println(threadNum);
                        semaphore.release();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        exec.shutdown();
    }
}
