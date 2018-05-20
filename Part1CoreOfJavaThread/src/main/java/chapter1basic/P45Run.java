/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/3/18 下午11:36
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter1basic;

public class P45Run {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            P45MyThread1 thread1 = new P45MyThread1();
            thread1.setPriority(1);
            thread1.start();
            P45MyThread2 thread2 = new P45MyThread2();
            thread2.setPriority(10);
            thread2.start();
        }
    }
}
