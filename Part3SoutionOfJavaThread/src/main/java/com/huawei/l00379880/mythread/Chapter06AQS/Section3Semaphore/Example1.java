package com.huawei.l00379880.mythread.Chapter06AQS.Section3Semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/***********************************************************
 * @note      : emaphore可以用于做流量控制，特别公用资源有限的应用场景，比如数据库连接。
 * 假如有一个需求，要读取几万个文件的数据，因为都是IO密集型任务，我们可以启动几十个线程并发的读取，
 * 但是如果读到内存后，还需要存储到数据库中，而数据库的连接数只有10个，这时我们必须控制只有十个线程同时获取数据库连接保存数据，
 * 否则会报错无法获取数据库连接。这个时候，我们就可以使用Semaphore来做流控。
 * @author    : l00379880 梁山广
 * @version   : V1.0 at 2019/9/3 20:11
 ***********************************************************/
public class Example1 {
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
                try {
                    semaphore.acquire();
                    System.out.println(threadNum);
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        exec.shutdown();
    }
}
