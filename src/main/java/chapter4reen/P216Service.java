/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/9 下午9:44
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter4reen;

import java.util.concurrent.locks.ReentrantLock;

public class P216Service {
    private ReentrantLock lock;

    public P216Service(boolean fair) {
        this.lock = new ReentrantLock(fair);
    }

    public void serviceMethod() {
        try {
            lock.lock();
            System.out.println("ThreadName = " + Thread.currentThread().getName() + " 获得锁定！");
        } finally {
            lock.unlock();
        }
    }


}
