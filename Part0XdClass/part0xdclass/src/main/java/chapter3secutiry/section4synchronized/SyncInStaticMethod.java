/***********************************************************
 * @Description : synchronized修饰静态方法是锁住类
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018-12-16 19:10
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3secutiry.section4synchronized;

public class SyncInStaticMethod {
    public static synchronized void out() throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        Thread.sleep(5000L);
    }

    public static void main(String[] args) {
        SyncInStaticMethod demo1 = new SyncInStaticMethod();
        SyncInStaticMethod demo2 = new SyncInStaticMethod();

        // 因为静态方法锁住的是类，所以下面两个线程只能先后进入
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
