package com.huawei.l00379880.mythread.Chapter06AQS.Section4CyclicBarrier;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/***********************************************************
 * @note      : CyclicBarrier基本使用案例
 * @author    : l00379880 梁山广
 * @version   : V1.0 at 2019/9/3 21:05
 ***********************************************************/

@Slf4j
public class Example1 {
    // 给定一个值，指定有多少个线程同步等待
    private static CyclicBarrier barrier = new CyclicBarrier(5);

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            final int num = i;
            // 延迟1s方便观察
            exec.execute(() -> {
                try {
                    Example1.race(num);
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }
        exec.shutdown();
    }

    private static void race(int num) throws InterruptedException, BrokenBarrierException {
        Thread.sleep(1000);
        System.out.println(num + " is ready");
        // 阻塞线程,没等到5个线程到达屏障时才开始向下执行continue
        barrier.await();
        System.out.println(num + " continue");
    }
}

/**
 * 输出：
 * <p>
 * 1 is ready
 * 5 is ready
 * 9 is ready
 * 8 is ready
 * 3 is ready
 * 3 continue
 * 0 is ready
 * 4 is ready
 * 1 continue
 * 5 continue
 * 9 continue
 * 7 is ready
 * 2 is ready
 * 6 is ready
 * 6 continue
 * 8 continue
 * 0 continue
 * 4 continue
 * 7 continue
 * 2 continue
 */
