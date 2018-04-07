/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 下午12:48
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3com;

public class P149NotifyThread extends Thread {
    private Object lock;

    public P149NotifyThread(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        // notify一定要同步，不然会出IllegalMonitorStateException的错误
        synchronized (lock) {
            // 随机选取一个线程进行唤醒
            lock.notify();
        }
    }
}
