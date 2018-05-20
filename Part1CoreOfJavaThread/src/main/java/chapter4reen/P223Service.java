/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/9 下午10:35
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter4reen;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class P223Service {
    public ReentrantLock lock = new ReentrantLock();
    public Condition condition = lock.newCondition();
    public void waitMethod(){
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
            System.out.println("有没有线程正在等待condition?"+lock.hasWaiters(condition)+",线程数是多少？"+lock.getWaitQueueLength(condition));
            // signal地话，Run里会显示剩9个；signalAll地话会是0个
            condition.signal();
            System.out.println("有没有线程正在等待condition?"+lock.hasWaiters(condition)+",线程数是多少？"+lock.getWaitQueueLength(condition));
        } finally {
            lock.unlock();
        }
    }
}
