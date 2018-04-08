/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/8 下午10:48
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter4reen;

public class P207ThreadA extends Thread {
    private P207MyService myService;

    public P207ThreadA(P207MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.await();
    }
}
