/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/9 下午10:18
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter4reen;

public class P220Run {
    public static void main(String[] args) throws InterruptedException {
        final P220Service service = new P220Service();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                service.serviceMethod1();
            }
        };

        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(runnable);
        }
        for (int i = 0; i < 10; i++) {
            threads[i].start();
        }
        Thread.sleep(2000);
        System.out.println("有线程数：" + service.lock.getQueueLength() + "在等待！");
    }
}
