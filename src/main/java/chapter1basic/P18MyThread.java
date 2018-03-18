/***********************************************************
 * @Description : isAlive判断当前的线程是否处于活动状态
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/3/18 下午7:06
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter1basic;

public class P18MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("running? " + this.isAlive());
    }
}
