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
    public static int clientTotal = 1000;
    /**
     * 同时并发执行地线程数
     */
    public static int threadTotal = 50;
    /**
     * 计数
     */
    public static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        // 创建线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        // 控制并发数
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (InterruptedException e) {
                    log.error("exception", e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("count:{}", count);
    }

    public static void add() {
        count++;
    }
}
