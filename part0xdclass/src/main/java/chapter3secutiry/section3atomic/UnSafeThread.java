/***********************************************************
 * @Description : 不安全的线程
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018-12-16 18:38
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3secutiry.section3atomic;

import java.util.concurrent.CountDownLatch;

public class UnSafeThread {
    private static volatile int num = 0;

    private static CountDownLatch countDownLatch = new CountDownLatch(10);

    /**
     * 通过加 synchronized 使函数成为原子操作
     */
    private static synchronized void inCreate() {
        // 实际这个语句不是原子操作，分很多步骤=地
        num++;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    inCreate();
                    try {
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
