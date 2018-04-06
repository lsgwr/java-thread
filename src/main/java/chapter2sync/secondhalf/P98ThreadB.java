/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/6 下午5:24
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync.secondhalf;

public class P98ThreadB extends Thread {
    private P97Service service;

    public P98ThreadB(P97Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        P97Service.printB();
    }
}
