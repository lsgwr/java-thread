/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/3/18 下午6:22
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter1basic;

public class P14Run {
    public static void main(String[] args) {
        P14MyThread run = new P14MyThread();
        Thread t1 = new Thread(run);
        Thread t2 = new Thread(run);
        Thread t3 = new Thread(run);
        Thread t4 = new Thread(run);
        Thread t5 = new Thread(run);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
