/***********************************************************
 * @Description : 原子性测试,Boolean类型实现代码只执行一次
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/7/15 22:18
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package com.huawei.l00379880.mythread.Chapter03Security;

import com.huawei.l00379880.mythread.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

@Slf4j
@ThreadSafe
public class CountExampleAtomicBoolean {
    private static int threadTotal = 200;
    private static int clientTotal = 5000;

    private static AtomicBoolean isExcute = new AtomicBoolean(false);

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        for (int i = 0; i < clientTotal; i++) {
            exec.execute(() -> {
                try {
                    semaphore.acquire();
                    test();
                    semaphore.release();
                } catch (InterruptedException e) {
                    log.error("exception:{}", e);
                }
            });
        }
        exec.shutdown();
        log.info("isExcute:{}", isExcute);
    }

    private static void test() {
        // 只会执行一次
        if (isExcute.compareAndSet(false, true)) {
            log.info("excuted!!");
        }
    }
}
