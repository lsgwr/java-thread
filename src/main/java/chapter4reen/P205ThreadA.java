/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 下午11:53
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter4reen;

public class P205ThreadA extends Thread{
    private P205MyService service;

    public P205ThreadA(P205MyService service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.await();
    }
}
