/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018-12-15 19:55
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2.section6interrupt;

public class InterruptDemo2 implements Runnable {
    /**
     * 多线程中的标志位必须是volatile类型!
     */
    private static volatile boolean FLAG = true;

    @Override
    public void run() {
        while (FLAG) {
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new InterruptDemo2());
        thread.start();
        Thread.sleep(1000L);
        FLAG = false;
    }
}
