/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/9 下午10:24
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter4reen;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class P221Service {
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void waitMethod() {
        try {
            lock.lock();
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void notifyMethod() {
        try {
            lock.lock();
            System.out.println("有 " + lock.getWaitQueueLength(condition) + "个线程在等在condition!即在await()");
            // signal地话，Run里会显示剩9个；signalAll地话会是0个
            condition.signalAll();
            System.out.println("有 " + lock.getWaitQueueLength(condition) + "个线程在等在condition!即在await()");
        } finally {
            lock.unlock();
        }
    }
}
