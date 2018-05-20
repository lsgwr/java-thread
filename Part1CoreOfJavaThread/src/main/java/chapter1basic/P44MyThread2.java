/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/3/18 下午9:40
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter1basic;

public class P44MyThread2 extends Thread {
    @Override
    public void run() {
        System.out.println("P44MyThread2 run priority = " + this.getPriority());
    }
}
