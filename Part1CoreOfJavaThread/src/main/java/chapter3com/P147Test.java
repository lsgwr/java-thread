/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 下午1:09
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3com;

public class P147Test {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        P147ThreadA a = new P147ThreadA(lock);
        a.start();
        Thread.sleep(5000);
        a.interrupt();
    }
}
