/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2019-08-04 22:16
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter5communication.section4ThreadJoin;

public class ThreadJoinTest {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "-----开始");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(Thread.currentThread().getName() + "----结束");
            }

        }, "线程1");



        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "-----开始");
                try {
                    // start和join都放在这里
                    thread.start();
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(Thread.currentThread().getName() + "----结束");
                }
            }
        }, "线程2").start();
    }
}
