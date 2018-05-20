/***********************************************************
 * @Description : 通知过早，会打乱程序正常的运行逻辑.所以wait的线程
 *                启动后要延一下时再启动notify的线程
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 下午4:22
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3com;

public class P152MyRun {
    private String lock = new String("");
    private boolean firstRunB = false;
    private Runnable runnable1 = new Runnable() {
        @Override
        public void run() {
            try {
                synchronized (lock) {
                    while (firstRunB == false) {
                        System.out.println("begin wait");
                        lock.wait();
                        System.out.println("  end wait");
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };
    private Runnable runnable2 = new Runnable() {
        @Override
        public void run() {
            synchronized (lock) {
                System.out.println("begin notify");
                lock.notify();
                System.out.println("  end notify");
                firstRunB = true;
            }
        }
    };

    public static void main(String[] args) throws InterruptedException {
        P152MyRun run = new P152MyRun();
        Thread t1 = new Thread(run.runnable1);
        t1.start();
        Thread.sleep(100);
        Thread t2 = new Thread(run.runnable2);
        t2.start();
    }
}
