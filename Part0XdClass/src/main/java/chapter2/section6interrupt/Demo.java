/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018-12-15 19:20
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2.section6interrupt;

public class Demo implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        try {
            // 1s打印一次线程名
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Demo());
        thread.start();
        Thread.sleep(3000L);
        thread.stop();
    }
}
