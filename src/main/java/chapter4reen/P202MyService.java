/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 下午11:40
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter4reen;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class P202MyService {
    private Lock lock=new ReentrantLock();

    public  void methodA(){
        try {
            lock.lock();
            System.out.println("methodA begin ThreadName = "+Thread.currentThread().getName()+", time = "+System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("methodA   end ThreadName = "+Thread.currentThread().getName()+", time = "+System.currentTimeMillis());
            lock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public  void methodB(){
        try {
            lock.lock();
            System.out.println("methodB begin ThreadName = "+Thread.currentThread().getName()+", time = "+System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("methodB   end ThreadName = "+Thread.currentThread().getName()+", time = "+System.currentTimeMillis());
            lock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
