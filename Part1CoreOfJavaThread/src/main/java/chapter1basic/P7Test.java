/***********************************************************
 * @Description : 验证start()方法的顺序不代表线程启动的顺序
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/3/18 下午1:48
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter1basic;

public class P7Test {
    public static void main(String[] args) {
        P7MyThread t1=new P7MyThread(1);
        P7MyThread t2=new P7MyThread(2);
        P7MyThread t3=new P7MyThread(3);
        P7MyThread t4=new P7MyThread(4);
        P7MyThread t5=new P7MyThread(5);
        P7MyThread t6=new P7MyThread(6);
        P7MyThread t7=new P7MyThread(7);
        P7MyThread t8=new P7MyThread(8);
        P7MyThread t9=new P7MyThread(9);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
    }
}
