/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/6 下午7:34
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync.secondhalf;

public class P114Run {
    public static void main(String[] args) {
        final P113OuterClass.InnerClass1 innerClass1 = new P113OuterClass.InnerClass1();
        final P113OuterClass.InnerClass2 innerClass2 = new P113OuterClass.InnerClass2();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                innerClass1.method1(innerClass2);
            }
        }, "thread1");
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                innerClass1.method2();
            }
        }, "thread2");
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                innerClass2.method1();
            }
        }, "thread3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
