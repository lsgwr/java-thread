/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/8 下午11:04
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter4reen;

public class P210Run {
    public static void main(String[] args) throws InterruptedException {
        P208MyService myService = new P208MyService();
        P209ThreadA a = new P209ThreadA(myService);
        a.setName("A");
        a.start();
        P209ThreadB b = new P209ThreadB(myService);
        b.setName("B");
        b.start();
        Thread.sleep(3000);
        myService.signalAll();
    }
}
