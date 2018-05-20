/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 下午1:07
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3com;

public class P147ThreadA extends Thread {
    private Object lock;

    public P147ThreadA(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        P147Service service = new P147Service();
        service.testMethod(lock);
    }
}
