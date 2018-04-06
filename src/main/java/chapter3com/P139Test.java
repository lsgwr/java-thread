/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 上午12:25
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3com;

public class P139Test {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        P138MyThread1 t1 = new P138MyThread1(lock);
        t1.start();
        // 3s后notify
        Thread.sleep(3000);
        P138MyThread2 t2 = new P138MyThread2(lock);
        t2.start();
    }
}
