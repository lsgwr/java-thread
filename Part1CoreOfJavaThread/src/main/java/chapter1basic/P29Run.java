/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/3/18 下午8:13
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter1basic;

public class P29Run {
    public static void main(String[] args) {
        try {
            P29MyThread thread = new P29MyThread();
            thread.start();
            Thread.sleep(1000);
            thread.interrupt();
        } catch (InterruptedException e) {
            System.out.println("main catch exception");
            e.printStackTrace();
        }
        System.out.println("end");
    }
}
