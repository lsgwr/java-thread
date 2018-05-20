/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 下午1:07
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3com;

public class P148ThreadB extends Thread {
    private Object lock;

    public P148ThreadB(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        P148Service service = new P148Service();
        service.testMethod(lock);
    }
}
