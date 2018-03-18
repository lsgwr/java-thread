/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/3/18 下午9:44
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter1basic;

public class P44Run {
    public static void main(String[] args) {
        System.out.println("main thread begin priority = " + Thread.currentThread().getPriority());
        System.out.println("main thread end   priority = " + Thread.currentThread().getPriority());
        Thread.currentThread().setPriority(6);
        // thread1会继承main线程的优先级
        P43MyThread1 thread1 = new P43MyThread1();
        thread1.start();
    }
}
