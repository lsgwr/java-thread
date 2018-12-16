/***********************************************************
 * @Description : synchronized修饰普通方法是锁住实例
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018-12-16 19:10
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3secutiry.section4synchronized;

public class SyncInMethod {
    public synchronized void out() throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        Thread.sleep(5000L);
    }

    public static void main(String[] args) {
        SyncInMethod demo1 = new SyncInMethod();
        SyncInMethod demo2 = new SyncInMethod();

        // 因为普通方法锁住的是实例，所以下面两个线程都是可以同时进去地
        new Thread(() -> {
            try {
                demo1.out();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                demo2.out();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
