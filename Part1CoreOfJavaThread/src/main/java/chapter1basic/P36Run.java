/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/3/18 下午8:28
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter1basic;

public class P36Run {
    public static void main(String[] args) {
        try {
            P36MyThread t=new P36MyThread();
            t.start();
            Thread.sleep(1000);
            t.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
