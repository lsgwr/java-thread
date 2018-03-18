/***********************************************************
 * @Description : 线程的interrupt()方法并不能使线程真正地停下
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/3/18 下午7:35
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter1basic;

public class P25MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 500000; i++) {
            System.out.println("i = " + (i + 1));
        }
    }
}
