/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/6 上午11:38
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync.firsthalf;

public class P86ThreadA extends Thread {
    private P86Service service;

    public P86ThreadA(P86Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.a();
    }
}
