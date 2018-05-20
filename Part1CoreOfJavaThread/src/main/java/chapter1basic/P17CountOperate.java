/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/3/18 下午6:57
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter1basic;

public class P17CountOperate extends Thread {
    public P17CountOperate() {
        System.out.println("*********构造函数：start*********");
        //当前线程的构造函数是在主函数Main中执行地
        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
        // 当前的构造函数属于线程Thread-0
        System.out.println("this.getName() = " + this.getName());
        System.out.println("*********构造函数：end***********");
        System.out.println();
    }

    @Override
    public void run() {
        System.out.println("*********run函数：start*********");
        //当前线程的run函数是在当前线程Thread-0中执行地
        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
        // 当前的构造函数属于线程Thread-0
        System.out.println("this.getName() = " + this.getName());
        System.out.println("*********run函数：end***********");
    }
}
