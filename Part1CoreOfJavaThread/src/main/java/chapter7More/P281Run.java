/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/12 下午11:04
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter7More;

public class P281Run {
    public static void main(String[] args) throws InterruptedException {
        P281MyThread t = new P281MyThread();
        System.out.println("main方法中的状态1：" + t.getState());
        Thread.sleep(1000);
        t.start();
        Thread.sleep(1000);
        System.out.println("main方法中的状态2：" + t.getState());
    }
}
