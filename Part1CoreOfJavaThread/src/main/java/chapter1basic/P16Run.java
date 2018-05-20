/***********************************************************
 * @Description :
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/3/18 下午6:35
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter1basic;

public class P16Run {
    public static void main(String[] args) {
        P16MyThread myThread = new P16MyThread();
        myThread.start();
        // 根据打印结果可知：P16MyThread的构造函数是被main线程调用地；
        // run方法是被创建的线程自动调用地(打印结果中的Thread-0)
    }
}
