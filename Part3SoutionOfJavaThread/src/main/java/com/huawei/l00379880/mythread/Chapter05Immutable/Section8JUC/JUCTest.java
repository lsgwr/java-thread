package com.huawei.l00379880.mythread.Chapter05Immutable.Section8JUC;

import java.util.*;
import java.util.concurrent.*;

/***********************************************************
 * @note      : 并发容器，都是线程安全的
 * List
 *   ArrayList对应的CopyOnWriteArrayList
 * Set
 *   HashSet对应的CopyOnWriteArraySet
 *   TreeSet对应的ConcurrentSkipListSet
 * Map
 *   HashMap对应的ConcurrentHashMap
 *   TreeMap对应的ConcurrentSkipListMap
 * @author    : l00379880 梁山广
 * @version   : V1.0 at 2019/8/30 10:52
 ***********************************************************/
public class JUCTest {
    /**
     * 请求总数
     */
    public static int clientTotal = 5000;
    /**
     * 同时并发执行地线程数
     */
    public static int threadTotal = 200;

    private static List<Integer> list = new CopyOnWriteArrayList<>();
    private static Set<Integer> set1 = new CopyOnWriteArraySet<>();
    private static Set<Integer> set2 = new ConcurrentSkipListSet<>();
    private static Map<Integer, Integer> map1 = new ConcurrentHashMap<>();
    private static Map<Integer, Integer> map2 = new ConcurrentSkipListMap<>();

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
        System.out.println("set1:" + set1.size());
        System.out.println("set2:" + set2.size());
        System.out.println("map1:" + map1.size());
        System.out.println("map2:" + map2.size());

    }

    private static void update(int finalI) {
        list.add(finalI);
        set1.add(finalI);
        set2.add(finalI);
        map1.put(finalI, finalI);
        map2.put(finalI, finalI);
    }
}
/**
 * 输出结果(并发)：
 * <p>
 * list:5000
 * set1:5000
 * set2:5000
 * map1:5000
 * map2:50000
 */
