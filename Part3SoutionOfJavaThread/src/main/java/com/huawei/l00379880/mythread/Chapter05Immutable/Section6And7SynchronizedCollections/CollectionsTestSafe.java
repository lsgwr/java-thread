package com.huawei.l00379880.mythread.Chapter05Immutable.Section6And7SynchronizedCollections;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/***********************************************************
 * @note      : 容器的同步实现
 * @author    : l00379880 梁山广
 * @version   : V1.0 at 2019/8/30 9:44
 ***********************************************************/
public class CollectionsTestSafe {
    /**
     * 请求总数
     */
    public static int clientTotal = 5000;
    /**
     * 同时并发执行地线程数
     */
    public static int threadTotal = 200;

    /**
     * List的线程安全实现：Vector，Collections.synchronizedList也行
     */
    private static Vector<Integer> list = new Vector<>();
    /**
     * set暂无现成的安全实现，后面会介绍Collections.synchronizedSet
     */
    private static Set<Integer> set = new HashSet<>();
    /**
     * Map的线程安全实现：Hashtable，Collections.synchronizedMap也行
     */
    private static Map<Integer, Integer> map = new Hashtable<>();

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
 * 输出结果(List和Map都切换成了Vector和Hashable，是线程安全的，所以结果是5000)：
 * <p>
 * list:5000
 * set:4990
 * map:5000
 */
