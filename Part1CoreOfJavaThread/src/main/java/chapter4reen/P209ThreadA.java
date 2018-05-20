/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/8 下午11:02
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter4reen;

public class P209ThreadA extends Thread {
    private P208MyService myService;

    public P209ThreadA(P208MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.awaitA();
    }
}
