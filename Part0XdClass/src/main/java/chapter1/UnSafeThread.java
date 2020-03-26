/***********************************************************
 * @Description : 不安全的线程操作
 * @author      : 梁山广(Liang Shan Guang)
 * @date        : 2020/3/27 0:25
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter1;

import java.util.concurrent.CountDownLatch;

/**
 * 线程不安全操作代码实例
 */
public class UnSafeThread {

    private static int num = 0;

    private static CountDownLatch countDownLatch = new CountDownLatch(10);

    /**
     * 每次调用对num进行++操作
     */
    public static void inCreate() {
        num++;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                for (int j = 0; j < 100; j++) {
                    inCreate();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //每个线程执行完成之后，调用countdownLatch
                countDownLatch.countDown();
            }).start();
        }

        while (true) {
            if (countDownLatch.getCount() == 0) {
                // 多跑几次，几乎每次的结果都小于1000，一般是900多
                System.out.println(num);
                break;
            }
        }
    }
}
