/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/9 下午10:39
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter4reen;

public class P222Run {
    public static void main(String[] args) throws InterruptedException {
        final P222Service service = new P222Service();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                service.waitMethod();
            }
        };

        Thread a = new Thread(runnable);
        a.start();
        Thread.sleep(500);
        Thread b = new Thread(runnable);
        b.start();
        Thread.sleep(500);
        System.out.println(service.lock.hasQueuedThread(a));
        System.out.println(service.lock.hasQueuedThread(b));
        System.out.println(service.lock.hasQueuedThreads());
    }
}
