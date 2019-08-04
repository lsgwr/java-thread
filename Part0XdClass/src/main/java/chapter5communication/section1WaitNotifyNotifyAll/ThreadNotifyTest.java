package chapter5communication.section1WaitNotifyNotifyAll;

public class ThreadNotifyTest {

    private static volatile boolean flag = false;

    public static void main(String[] args) throws InterruptedException {

        Object obj = new Object();

        new Thread(()->{
            while (!flag) {
                synchronized (obj) {
                    try {
                        System.out.println("flag is false");
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            System.out.println("flag is true");
        }).start();

        new Thread(()->{
            while (!flag) {
                synchronized (obj) {
                    try {
                        System.out.println("flag is false");
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            System.out.println("flag is true");
        }).start();

        Thread.sleep(1000L);

        new Thread(()->{
            flag = true;
            synchronized (obj) {
                // 要是用notify()只能唤醒一个
                obj.notifyAll();
            }
        }).start();
    }

}
