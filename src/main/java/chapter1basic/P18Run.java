/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/3/18 下午7:12
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter1basic;

public class P18Run {
    public static void main(String[] args) {
        P18MyThread myThread = new P18MyThread();
        System.out.println("begin : isAlive?" + myThread.isAlive());
        myThread.start();
        System.out.println("end : isAlive?" + myThread.isAlive());
    }
}
