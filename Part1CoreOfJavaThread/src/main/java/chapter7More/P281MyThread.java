/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/12 下午11:01
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter7More;

public class P281MyThread extends Thread {
    public P281MyThread() {
        System.out.println("构造方法中的状态："+Thread.currentThread().getState());
    }

    @Override
    public void run() {
        System.out.println("run方法中的状态："+Thread.currentThread().getState());
    }
}
