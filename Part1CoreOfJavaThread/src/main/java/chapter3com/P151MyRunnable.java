/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 下午3:44
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3com;

public class P151MyRunnable {
    static private Object lock = new Object();
    static private Runnable runnable1 = new Runnable() {
        @Override
        public void run() {
            try {
                synchronized (lock) {
                    System.out.println(" begin wait time = " + System.currentTimeMillis());
                    lock.wait(5000);
                    System.out.println(" end   wait time = " + System.currentTimeMillis());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };
    static private Runnable runnable2 = new Runnable() {
        @Override
        public void run() {
            synchronized (lock) {
                System.out.println(" notify wait time = " + System.currentTimeMillis());
                lock.notify();
                System.out.println(" notify   wait time = " + System.currentTimeMillis());
            }
        }
    };

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(runnable1);
        thread.start();
        // 在超时的时间以内，所以会被提前唤醒
        Thread.sleep(3000);
        Thread t2 = new Thread(runnable2);
        t2.start();
    }
}
