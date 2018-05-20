/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/3/18 下午7:36
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter1basic;

public class P24Run {
    public static void main(String[] args) {
        try {
            P23MyThread thread=new P23MyThread();
            thread.start();
            Thread.sleep(1000);
            thread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
