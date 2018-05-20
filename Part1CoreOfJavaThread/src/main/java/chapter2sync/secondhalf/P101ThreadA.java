/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/6 下午5:24
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync.secondhalf;

public class P101ThreadA extends Thread {
    private P101Service service;

    public P101ThreadA(P101Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.printA();
    }
}
