/***********************************************************
 * @Description : SimpleDateFormat线程安全写法(线程局部变量)
 * @author      : 梁山广(Liang Shan Guang)
 * @date        : 2019/8/30 08:15
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package com.huawei.l00379880.mythread.Chapter05Immutable.Section4And5UnsafeThreadExample;

import com.huawei.l00379880.mythread.annotations.ThreadSafe;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@ThreadSafe
public class SimpleDateFormatSafe {
    /**
     * 请求总数
     */
    public static int clientTotal = 5000;
    /**
     * 同时并发执行地线程数
     */
    public static int threadTotal = 200;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    update();
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
    }

    private static void update() {
        try {
            // 利用线程封闭的思想把SimpleDateFormat对象转变为线程局部变量，这样就线程安全了
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
            simpleDateFormat.parse("20180208");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
