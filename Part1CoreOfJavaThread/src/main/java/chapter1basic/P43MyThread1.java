/***********************************************************
 * @Description : 线程的继承性
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/3/18 下午9:35
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter1basic;

public class P43MyThread1 extends Thread {
    @Override
    public void run() {
        System.out.println("MyThread1 run priority = " + this.getPriority());
        // thread2继承了thread1的线程优先级
        P44MyThread2 thread2 = new P44MyThread2();
        thread2.start();
    }
}
