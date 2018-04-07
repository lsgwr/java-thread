/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 下午12:48
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3com;

public class P146SynNotifyThread extends Thread {
    private Object lock;

    public P146SynNotifyThread(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        P144Service service = new P144Service();
        service.synNotifyMethod(lock);
    }
}
