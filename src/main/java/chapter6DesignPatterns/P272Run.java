/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/12 上午12:26
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter6DesignPatterns;

public class P272Run {
    public static void main(String[] args) {
        P272MyThread myThread1 = new P272MyThread();
        P272MyThread myThread2 = new P272MyThread();
        P272MyThread myThread3 = new P272MyThread();
        myThread1.start();
        myThread2.start();
        myThread3.start();
    }
}
