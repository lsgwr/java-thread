/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018-12-15 19:48
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2.section6interrupt;

public class InterruptDemo implements Runnable {
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            // 检测到终止标记才推出死循环
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new InterruptDemo());
        thread.start();
        Thread.sleep(1000L);
        // 只是打上一个标志位，需要在代码中自己加以判断
        thread.interrupt();
    }
}
