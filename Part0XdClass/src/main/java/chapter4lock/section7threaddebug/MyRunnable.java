/***********************************************************
 * @Description : 多线程调试技巧，参考博文https://blog.csdn.net/nextyu/article/details/79039566
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2019-08-04 21:35
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter4lock.section7threaddebug;

import java.util.concurrent.TimeUnit;

public class MyRunnable implements Runnable {

    @Override
    public void run() {
        Thread currentThread = Thread.currentThread();
        System.out.println(currentThread.getName() + "-------------进入");

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(currentThread.getName() + "-------------离开");
        }

    }

    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread1 = new Thread(myRunnable, "线程1");
        Thread thread2 = new Thread(myRunnable, "线程2");
        Thread thread3 = new Thread(myRunnable, "线程3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
