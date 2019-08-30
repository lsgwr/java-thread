package com.huawei.l00379880.mythread.Chapter05Immutable.Section4And5UnsafeThreadExample;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/***********************************************************
 * @note      : 
 * @author    : l00379880 梁山广
 * @version   : V1.0 at 2019/8/30 9:44
 ***********************************************************/
public class CollectionsTest {
    /**
     * 请求总数
     */
    public static int clientTotal = 5000;
    /**
     * 同时并发执行地线程数
     */
    public static int threadTotal = 200;

    private static List<Integer> list = new ArrayList<>();
    private static Set<Integer> set = new HashSet<>();
    private static Map<Integer, Integer> map = new HashMap<>();

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
        System.out.println("list:" + list.size());
        System.out.println("set:" + set.size());
        System.out.println("map:" + map.size());

    }

    private static void update(int finalI) {
        list.add(finalI);
        set.add(finalI);
        map.put(finalI, finalI);
    }
}
/**
 * 输出结果(都小于5000，可见List、Set、Map都不是线程安全地)：
 * <p>
 * list:4996
 * set:4993
 * map:4992
 */
