/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 上午12:33
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3com;

public class P141Run {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        P140ThreadA a = new P140ThreadA(lock);
        a.start();
        Thread.sleep(50);
        P140ThreadB b=new P140ThreadB(lock);
        b.start();
    }
}
