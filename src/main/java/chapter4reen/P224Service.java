/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/9 下午10:50
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter4reen;

import java.util.concurrent.locks.ReentrantLock;

public class P224Service {
    public ReentrantLock lock;

    public P224Service(boolean fair) {
        this.lock = new ReentrantLock(fair);
    }

    public void serviceMethod(){
        try {
            lock.lock();
            // 默认是公平锁，由
            System.out.println("公平锁情况："+lock.isFair());
        } finally {
            lock.unlock();
        }
    }
}
