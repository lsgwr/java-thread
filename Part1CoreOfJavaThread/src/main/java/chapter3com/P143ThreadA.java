/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 下午12:03
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3com;

public class P143ThreadA extends Thread {
    private Object lock;

    public P143ThreadA(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        P143Service service = new P143Service();
        service.testMethod(lock);
    }
}

