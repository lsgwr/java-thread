/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 下午10:27
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3com;

public class P194Run {
    public static void main(String[] args) throws InterruptedException {
        P194ThreadA threadA = new P194ThreadA();
        threadA.start();
        Thread.sleep(1000);
        P194ThreadB threadB = new P194ThreadB();
        threadB.start();
    }
}
