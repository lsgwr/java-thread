/***********************************************************
 * @Description : currentThread()方法
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/3/18 下午6:33
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter1basic;

public class P16MyThread extends Thread {
    public P16MyThread() {
        System.out.println("构造方法的打印：" + Thread.currentThread().getName());
    }

    @Override
    public void run() {
        System.out.println("run方法的打印：" + Thread.currentThread().getName());
    }
}
