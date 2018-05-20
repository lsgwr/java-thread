/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/6 下午6:49
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync.secondhalf;

public class P108Run {
    public static void main(String[] args) throws InterruptedException {
        P107DealThread dealThread1 = new P107DealThread();
        dealThread1.setUsername("a");
        Thread thread1 = new Thread(dealThread1);
        thread1.start();
        Thread.sleep(100);
        dealThread1.setUsername("b");
        Thread thread2 = new Thread(dealThread1);
        thread2.start();
    }
}
