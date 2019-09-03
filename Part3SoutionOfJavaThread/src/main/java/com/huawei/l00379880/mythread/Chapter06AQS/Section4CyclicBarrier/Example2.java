package com.huawei.l00379880.mythread.Chapter06AQS.Section4CyclicBarrier;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/***********************************************************
 * @note      : CyclicBarrier使用案例，以防await无线阻塞进程，我们可以设置await的超时时间
 * @author    : l00379880 梁山广
 * @version   : V1.0 at 2019/9/3 21:05
 ***********************************************************/

@Slf4j
public class Example2 {
    // 给定一个值，指定有多少个线程同步等待
    private static CyclicBarrier barrier = new CyclicBarrier(5);

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            final int num = i;
            // 延迟1s方便观察
            exec.execute(() -> {
                try {
                    Example2.race(num);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        exec.shutdown();
    }

    private static void race(int num) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println(num + " is ready");
        // 阻塞线程,没等到5个线程到达屏障时才开始向下执行continue
        try {
            // 由于设置了超时时间后阻塞地线程可能会被中断，抛出BarrierException,如果想继续向下执行，需要加上try-catch
            barrier.await(1000, TimeUnit.MILLISECONDS);
        } catch (TimeoutException | InterruptedException | BrokenBarrierException e) {
            // 使用isBroken()方法来知道阻塞的线程是否被中断
            System.out.println("exception occurred " + e.getClass().getName() + " " + e.getMessage() + " . isBroken():" + barrier.isBroken());
        }
        System.out.println(num + " continue");
    }
}
/**
 * 输出：
 * <p>
 * 0 is ready
 * 8 is ready
 * 4 is ready
 * 1 is ready
 * 5 is ready
 * 5 continue
 * 9 is ready
 * 3 is ready
 * 7 is ready
 * 0 continue
 * 8 continue
 * 4 continue
 * 1 continue
 * 2 is ready
 * 6 is ready
 * 6 continue
 * 9 continue
 * 3 continue
 * 7 continue
 * 2 continue
 */
