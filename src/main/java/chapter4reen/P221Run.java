/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/9 下午10:28
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter4reen;

public class P221Run {
    public static void main(String[] args) throws InterruptedException {
        final P221Service service = new P221Service();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                service.waitMethod();
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
        service.notifyMethod();
    }
}
