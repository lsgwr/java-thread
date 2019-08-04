/***********************************************************
 * @Description : 不安全的线程
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018-12-16 18:38
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package main.java.chapter4lock.section2lock_basic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UnSafeThread {
    private static volatile int num = 0;

    private static CountDownLatch countDownLatch = new CountDownLatch(10);

    /**
     * lock是乐观锁，通过lock()和unlock()方法即可达到synchronized的效果
     */
    private static Lock lock = new ReentrantLock();

    private static void inCreate() {
        // 加锁
        lock.lock();
        // 实际这个语句不是原子操作，分很多步骤=地
        num++;
        // 解锁
        lock.unlock();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    inCreate();
                    try {
                        // 延时是为了延时线程不安全
                        Thread.sleep(10L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 每个线程完成之后，调用countDownLatch
                countDownLatch.countDown();
            }).start();
        }
        while (true) {
            if (countDownLatch.getCount() == 0) {
                System.out.println(num);
                break;
            }
        }
    }
}
