/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018-12-15 20:50
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2.section8dameon;

public class DameonDemo implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new DameonDemo());
        // 设置为守护线程，随着进程终止.一定要在start之前设置dameon
        thread.setDaemon(true);
        thread.start();
        Thread.sleep(2000L);
    }
}
