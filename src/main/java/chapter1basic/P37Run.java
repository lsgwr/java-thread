/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/3/18 下午8:40
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter1basic;

public class P37Run {
    public static void main(String[] args) throws InterruptedException {
        P37MyThread thread = new P37MyThread();
        thread.start();
        Thread.sleep(5000);
        /* A段 */
        // 线程暂停
        thread.suspend();
        System.out.println("A = " + System.currentTimeMillis() + " i = " + thread.getI());
        Thread.sleep(5000);
        System.out.println("A = " + System.currentTimeMillis() + " i = " + thread.getI());


        /* B段 */
        // 线程恢复
        thread.resume();
        Thread.sleep(5000);

        /* C段 */
        // 线程再次暂停
        thread.suspend();
        System.out.println("B = " + System.currentTimeMillis() + " i = " + thread.getI());
        Thread.sleep(5000);
        System.out.println("A = " + System.currentTimeMillis() + " i = " + thread.getI());
    }
}
