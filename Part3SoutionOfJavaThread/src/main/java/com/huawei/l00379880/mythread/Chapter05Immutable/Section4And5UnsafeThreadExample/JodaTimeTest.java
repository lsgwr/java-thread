package com.huawei.l00379880.mythread.Chapter05Immutable.Section4And5UnsafeThreadExample;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/***********************************************************
 * @note      : Joda的时间类测试
 * @author    : l00379880 梁山广
 * @version   : V1.0 at 2019/8/30 9:30
 ***********************************************************/
public class JodaTimeTest {
    /**
     * 请求总数
     */
    public static int clientTotal = 5000;
    /**
     * 同时并发执行地线程数
     */
    public static int threadTotal = 200;

    private static DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("yyyyMMdd");

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            int finalI = i;
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    update(finalI);
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

    private static void update(int finalI) {
        // 这里就不会报异常了，而且不需要把dateTimeFormatter声明为线程局部变量
        System.out.println("第" + finalI + "次循环" + DateTime.parse("20190830", dateTimeFormatter).toDate());
    }
}
