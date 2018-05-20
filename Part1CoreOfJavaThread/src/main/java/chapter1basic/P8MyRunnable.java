/***********************************************************
 * @Description : 继承自MyRunnable接口的线程
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/3/18 下午1:52
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter1basic;

public class P8MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("运行中....");
    }
}
