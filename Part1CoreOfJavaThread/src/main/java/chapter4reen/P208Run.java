/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/8 下午10:50
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter4reen;

public class P208Run {
    public static void main(String[] args) throws InterruptedException {
        P207MyService myService = new P207MyService();
        P207ThreadA threadA = new P207ThreadA(myService);
        threadA.start();
        Thread.sleep(3000);
        myService.signal();
    }
}
