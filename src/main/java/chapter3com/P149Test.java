/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 下午1:16
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3com;

public class P149Test {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        P148ThreadA a = new P148ThreadA(lock);
        a.start();
        P148ThreadB b = new P148ThreadB(lock);
        b.start();
        P148ThreadC c = new P148ThreadC(lock);
        c.start();
        Thread.sleep(1000);
        P149NotifyThread notifyThread = new P149NotifyThread(lock);
        notifyThread.start();
    }
}
