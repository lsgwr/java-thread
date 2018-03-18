/***********************************************************
 * @Description : 继承Thread类的线程
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/3/18 下午1:15
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter1basic;

public class P5MyThread extends Thread {
    @Override
    public void run() {
        super.run();
        System.out.println("P5MyTread");
    }
}
