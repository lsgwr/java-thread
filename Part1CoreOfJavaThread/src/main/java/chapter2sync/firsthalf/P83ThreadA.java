/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/6 上午11:22
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync.firsthalf;

public class P83ThreadA extends Thread {
    private P83Service service;

    public P83ThreadA(P83Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.setUsernameAndPassword("a", "aa");
    }
}
