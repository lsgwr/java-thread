/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/3/28 下午11:47
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync.firsthalf;

public class P81Run {
    public static void main(String[] args) throws InterruptedException {
        P80Task task = new P80Task();
        P80MyThread1 thread1 = new P80MyThread1(task);
        thread1.start();
        Thread.sleep(100);
        P80MyThread2 thread2 = new P80MyThread2(task);
        thread2.start();
    }
}
