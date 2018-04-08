/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/8 下午11:02
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter4reen;

public class P209ThreadB extends Thread {
    private P208MyService myService;

    public P209ThreadB(P208MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.awaitB();
    }
}
