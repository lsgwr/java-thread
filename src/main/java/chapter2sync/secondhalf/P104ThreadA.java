/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/6 下午6:10
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync.secondhalf;

public class P104ThreadA extends Thread {
    private P104Service service;

    public P104ThreadA(P104Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.print(new Object());
    }
}
