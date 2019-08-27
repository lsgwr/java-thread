/***********************************************************
 * @Description : 原子性测试,Long类型
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/7/15 21:22
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package com.huawei.l00379880.mythread.Chapter03Security;

import com.huawei.l00379880.mythread.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
@ThreadSafe
public class CountExampleAtomicLong {
    private static int threadTotal = 200;
    private static int clientTotal = 5000;

    private static AtomicLong count = new AtomicLong(0);

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        for (int i = 0; i < clientTotal; i++) {
            exec.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (InterruptedException e) {
                    log.error("exception:{}", e);
                }
            });
        }
        exec.shutdown();
        log.info("count:{}", count.get());
    }

    private static void add() {
        count.incrementAndGet();
    }
}
