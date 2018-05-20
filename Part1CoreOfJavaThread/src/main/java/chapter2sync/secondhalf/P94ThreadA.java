/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/6 下午2:06
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync.secondhalf;

public class P94ThreadA extends Thread {
    private P94Service service;
    private P93MyObject object;

    public P94ThreadA(P94Service service, P93MyObject object) {
        this.service = service;
        this.object = object;
    }

    @Override
    public void run() {
        service.testMethod1(object);
    }
}
