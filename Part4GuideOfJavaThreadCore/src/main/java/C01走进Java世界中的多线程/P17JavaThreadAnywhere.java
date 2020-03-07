/***********************************************************
 * @Description : 线程类的基本方法
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/5/22 00:22
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package C01走进Java世界中的多线程;

public class P17JavaThreadAnywhere {
    public static void main(String[] args) {
        System.out.println("The method is executed by thread : " + Thread.currentThread().getName());
        Helper helper = new Helper("Java Thread AnyWhere");
        // main中直接调用函数
        helper.run();
        // 创建线程取跑
        Thread t = new Thread(helper);
        t.start();

    }

    static class Helper implements Runnable {

        private final String msg;

        Helper(String msg) {
            this.msg = msg;
        }

        private void doSomething(String msg) {
            System.out.println("The 'doSomething' method was executed by thread : " + Thread.currentThread().getName());
            System.out.println("Do something with " + msg);
        }

        @Override
        public void run() {
            doSomething(msg);
        }
    }
}
/**
 * The method is executed by thread : main
 * The 'doSomething' method was executed by thread : main
 * Do something with Java Thread AnyWhere
 * The 'doSomething' method was executed by thread : Thread-0
 * Do something with Java Thread AnyWhere
 */
