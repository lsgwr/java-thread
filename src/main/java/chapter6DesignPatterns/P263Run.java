/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/11 下午10:53
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter6DesignPatterns;

public class P263Run {
    public static void main(String[] args) {
        P263MyThread thread1 = new P263MyThread();
        P263MyThread thread2 = new P263MyThread();
        P263MyThread thread3 = new P263MyThread();
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
