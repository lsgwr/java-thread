/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/12 上午12:26
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter6DesignPatterns;

public class P275Run {
    public static void main(String[] args) {
        P275MyThread myThread1 = new P275MyThread();
        P275MyThread myThread2 = new P275MyThread();
        P275MyThread myThread3 = new P275MyThread();
        myThread1.start();
        myThread2.start();
        myThread3.start();
    }
}
