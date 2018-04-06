/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 上午12:22
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3com;

public class P138MyThread2 extends Thread {
    private Object lock;

    public P138MyThread2(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            System.out.println("开始        notify time = " + System.currentTimeMillis());
            lock.notify();
            System.out.println("结束        notify time = " + System.currentTimeMillis());
        }
    }
}
