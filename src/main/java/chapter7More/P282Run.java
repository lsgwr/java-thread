/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/13 上午12:17
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter7More;

public class P282Run {
    public static void main(String[] args) throws InterruptedException {
        P282MyThread thread = new P282MyThread();
        thread.start();
        Thread.sleep(1000);
        System.out.println("main方法中的状态：" + thread.getState());
    }
}
