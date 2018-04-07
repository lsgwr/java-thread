/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 下午12:29
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3com;

public class P144Test {
    public static void main(String[] args) {
        Object lock = new Object();
        P143ThreadA a = new P143ThreadA(lock);
        a.start();
        P143ThreadB b = new P143ThreadB(lock);
        b.start();
    }
}
