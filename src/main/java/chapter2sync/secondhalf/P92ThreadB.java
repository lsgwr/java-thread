/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/6 下午1:45
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync.secondhalf;

public class P92ThreadB extends Thread {
    private P91Service service;
    private P91MyObject object;

    public P92ThreadB(P91Service service, P91MyObject object) {
        this.service = service;
        this.object = object;
    }

    @Override
    public void run() {
        service.testMethod1(object);
    }
}
