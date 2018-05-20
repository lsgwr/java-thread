/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/3/19 上午12:07
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter1basic;

public class P50Run {
    public static void main(String[] args) throws InterruptedException {
        P50MyThread thread = new P50MyThread();
        thread.setDaemon(true);
        thread.start();
        Thread.sleep(5000);
        System.out.println("我离开thread对象再也不打印了，也就是停止了！");
    }
}
