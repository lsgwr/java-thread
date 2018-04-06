/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/6 下午6:24
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync.secondhalf;

public class P105ThreadA extends Thread {
    private P105Service service;

    public P105ThreadA(P105Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.methodA();
    }
}
