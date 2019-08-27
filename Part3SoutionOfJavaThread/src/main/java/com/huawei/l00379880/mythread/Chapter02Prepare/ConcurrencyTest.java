/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/7/15 20:50
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package com.huawei.l00379880.mythread.Chapter02Prepare;

import com.huawei.l00379880.mythread.annotations.ThreadNotSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@Slf4j
@ThreadNotSafe
public class ConcurrencyTest {
    /**
     * 请求总数
     */
    public static int clientTotal = 50000;
    /**
     * 同时并发执行地线程数
     */
    public static int threadTotal = 200;
    /**
     * 计数
     */
    public static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        // 创建线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        // 控制并发数
        final Semaphore semaphore = new Semaphore(threadTotal);
        // 请求计数
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        // 放入请求
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        // 判断显示是否空闲，空闲就尝试获取锁
                        semaphore.acquire();
                        add();
                        semaphore.release();
                    } catch (InterruptedException e) {
                        log.error("exception", e);
                    }
                    countDownLatch.countDown();
                }
            });
        }
        // 等待countDownLatch减为0
        countDownLatch.await();
        // 关闭线程池
        executorService.shutdown();
        log.info("count:{}", count);
    }

    public static void add() {
        count++;
    }
}

/**
 * 执行可以看到并没输出预期的50000
 * <p>
 * 11:08:41.282 [main] INFO com.huawei.l00379880.mythread.Chapter02Prepare.ConcurrencyTest - count:49995
 */
