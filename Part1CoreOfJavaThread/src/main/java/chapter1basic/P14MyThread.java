/***********************************************************
 * @Description : i--与sout的异常
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/3/18 下午6:20
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter1basic;

public class P14MyThread extends Thread {
    private int i = 5;

    /**
     * 注意i--不是同步的，所以可能会引起非线程安全
     */
    @Override
    synchronized public void run() {
        System.out.println("i = " + (i--) + ", threadName = " + Thread.currentThread().getName());
    }
}
