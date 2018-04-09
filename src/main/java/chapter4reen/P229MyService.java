/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/9 下午11:45
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter4reen;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class P229MyService {
    public ReentrantLock lock = new ReentrantLock();

    public void waitMethod(){
        try {
            if (lock.tryLock(3,TimeUnit.SECONDS)){
                System.out.println("    "+Thread.currentThread().getName()+" 获得锁的时间："+System.currentTimeMillis());
                Thread.sleep(10000);
            }else {
                System.out.println("    "+Thread.currentThread().getName()+" 没有获得锁！");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (lock.isHeldByCurrentThread()){
                lock.unlock();
            }
        }
    }
}
