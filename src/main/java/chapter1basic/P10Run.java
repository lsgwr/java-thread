/***********************************************************
 * @Description : P10MyThread的测试类
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/3/18 下午5:39
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter1basic;

public class P10Run {
    public static void main(String[] args) {
        P10MyThread thread1 = new P10MyThread("thread1");
        P10MyThread thread2 = new P10MyThread("thread2");
        P10MyThread thread3 = new P10MyThread("thread3");
        thread1.start();
        thread2.start();
        thread3.start();
    }

}
