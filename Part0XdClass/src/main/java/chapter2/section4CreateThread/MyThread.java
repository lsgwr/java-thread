/***********************************************************
 * @Description : 方法2：继承Thread类
 * @author      : 梁山广(Liang Shan Guang)
 * @date        : 2020/3/27 0:40
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2.section4CreateThread;

public class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.setName("线程demo");
        myThread.start();
    }
}
