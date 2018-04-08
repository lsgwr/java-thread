/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/9 上午12:04
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter4reen;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class P211MyService {
    private Lock lock = new ReentrantLock();
    public Condition conditionA = lock.newCondition();
    public Condition conditionB = lock.newCondition();
    public void awaitA() {
        try {
            lock.lock();
            System.out.println("begin awaitA 时间为 " + System.currentTimeMillis() + ", ThreadName = " + Thread.currentThread().getName());
            conditionA.await();
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
            conditionB.await();
            System.out.println("  end awaitB 时间为 " + System.currentTimeMillis() + ", ThreadName = " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void signalAll_A(){
        try {
            lock.lock();
            System.out.println("signalAll_A 时间为 " + System.currentTimeMillis() + ", ThreadName = " + Thread.currentThread().getName());
            conditionA.signalAll();
        } finally {
            lock.unlock();
        }
    }
    public void signalAll_B(){
        try {
            lock.lock();
            System.out.println("signalAll_B 时间为 " + System.currentTimeMillis() + ", ThreadName = " + Thread.currentThread().getName());
            conditionB.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
