/***********************************************************
 * @Description : synchronized修饰代码块,锁住的是对象实例
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018-12-16 19:10
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3secutiry.section4synchronized;

public class SyncInCodeBlock {
    Object object = new Object();

    public void out(){

        synchronized (object) {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SyncInCodeBlock demo1 = new SyncInCodeBlock();
        SyncInCodeBlock demo2 = new SyncInCodeBlock();

        // synchronized修饰代码块,锁住的是对象实例，所以是一起进去地
        new Thread(() -> {
            demo1.out();
        }).start();

        new Thread(() -> {
            demo2.out();
        }).start();
    }
}
