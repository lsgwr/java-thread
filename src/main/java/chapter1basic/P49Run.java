/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/3/18 下午11:50
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter1basic;

public class P49Run {
    public static void main(String[] args) throws InterruptedException {
        P49ThreadA a = new P49ThreadA();
        a.setPriority(Thread.NORM_PRIORITY - 3);
        a.start();
        P49ThreadB b = new P49ThreadB();
        b.setPriority(Thread.NORM_PRIORITY + 3);
        b.start();
        Thread.sleep(2000);
        a.stop();
        b.stop();
        System.out.println("a = " + a.getCount());
        System.out.println("b = " + b.getCount());
    }
}
