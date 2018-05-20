/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 下午10:20
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3com;

public class P193Run {
    public static void main(String[] args) throws InterruptedException {
        P192ThreadA threadA = new P192ThreadA();
        P192ThreadB threadB = new P192ThreadB();
        threadA.start();
        threadB.start();
        for (int i = 0; i < 100; i++) {
            P192Tools.t1.set("Main " + (i + 1));
            System.out.println("Main get Value = "+P192Tools.t1.get());
            Thread.sleep(200);
        }
    }
}
