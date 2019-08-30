package com.huawei.l00379880.mythread.Chapter05Immutable.Section6And7SynchronizedCollections;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/***********************************************************
 * @note      : Collections.synchronizedXXX可以把原始集合转化为线程安全的集合
 * @author    : l00379880 梁山广
 * @version   : V1.0 at 2019/8/30 10:52
 ***********************************************************/
public class CollectionsTestSafe2 {
    /**
     * 请求总数
     */
    public static int clientTotal = 5000;
    /**
     * 同时并发执行地线程数
     */
    public static int threadTotal = 200;

    private static List<Integer> list = Collections.synchronizedList(new ArrayList<>());
    private static Set<Integer> set = Collections.synchronizedSet(new HashSet<>());
    private static Map<Integer, Integer> map = Collections.synchronizedMap(new HashMap<>());

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
 * 输出结果(Collections.synchronizedXXX可以把原始集合转化为线程安全的集合)：
 * <p>
 * list:5000
 * set:5000
 * map:5000
 */
