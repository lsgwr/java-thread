/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/6 下午10:48
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync.secondhalf;

public class P130ThreadA extends Thread {
    private P130Service service;

    public P130ThreadA(P130Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.runMethod();
    }
}
