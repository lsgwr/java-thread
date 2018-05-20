/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/3/25 下午9:50
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync.firsthalf;

public class P68ThreadB extends Thread {
    private P68Service service;

    public P68ThreadB(P68Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.testMethod();
    }
}
