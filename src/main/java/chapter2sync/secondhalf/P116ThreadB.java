/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/6 下午7:58
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync.secondhalf;

public class P116ThreadB extends Thread {
    private P115MyService service;

    public P116ThreadB(P115MyService service) {
        this.service = service;
    }


    @Override
    public void run() {
        service.testMethod();
    }
}
