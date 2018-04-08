/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/8 下午10:58
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter4reen;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class P208MyService {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void awaitA() {
        try {
            lock.lock();
            System.out.println("begin awaitA 时间为 " + System.currentTimeMillis() + ", ThreadName = " + Thread.currentThread().getName());
            condition.await();
            System.out.println("  end awaitA 时间为 " + System.currentTimeMillis() + ", ThreadName = " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void awaitB() {
        try {
            lock.lock();
            System.out.println("begin awaitB 时间为 " + System.currentTimeMillis() + ", ThreadName = " + Thread.currentThread().getName());
            condition.await();
            System.out.println("  end awaitB 时间为 " + System.currentTimeMillis() + ", ThreadName = " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void signalAll() {
        try {
            lock.lock();
            System.out.println("   signalAll时间为 " + System.currentTimeMillis() + ", ThreadName = " + Thread.currentThread().getName());
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
