/***********************************************************
 * @Description : suspend和resume方法使用不当时，极易造成公共的同步对象的独占
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/3/18 下午8:48
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter1basic;

public class P38SynchronizedObject {
    synchronized public void printString(){
        System.out.println("begin");
        if (Thread.currentThread().getName().equals("a")){
            System.out.println("a线程永远suspend了！");
            Thread.currentThread().suspend();
        }
        System.out.println("end");
    }
}
