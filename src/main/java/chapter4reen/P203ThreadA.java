/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 下午11:46
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter4reen;

public class P203ThreadA extends Thread {
    private P202MyService service;

    public P203ThreadA(P202MyService service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.methodA();
    }
}
