package chapter8tool;

import java.util.concurrent.Semaphore;

public class Section3SemaphoreDemo {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);

        for (int i = 0; i < 10; i++) { // 这里是10个线程，但是被Semaphore控制后，只有在前两个线程启动后才会启动后面8个
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "开始执行");
                    Thread.sleep(5000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }).start();
        }
    }
    
}
