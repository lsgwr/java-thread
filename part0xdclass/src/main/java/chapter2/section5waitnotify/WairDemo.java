/***********************************************************
 * @Description : 线程的挂起与恢复(wait与notify)
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018-12-15 15:44
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2.section5waitnotify;

public class WairDemo implements Runnable {
    private static Object object = new Object();

    @Override
    public void run() {
        // 持有资源
        synchronized (object) {
            System.out.println(Thread.currentThread().getName() + "占用资源");
            try {
                object.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 释放资源
        System.out.println(Thread.currentThread().getName() + "释放资源");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new WairDemo(), "对比线程1");
        thread1.start();

        Thread thread2 = new Thread(new WairDemo(), "对比线程2");
        thread2.start();
        Thread.sleep(3000L);
        // 锁住的和释放的必须是同一个object的锁
        synchronized (object) {
            // 随机唤醒一个正在等待的线程
            // object.notify();
            //唤醒所有正在等待的线程
            object.notifyAll();
        }
    }
}
