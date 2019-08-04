/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2019-08-04 21:39
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter4lock.section5ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLockDemo
 */
public class ReentrantLockDemo {

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock(true);
        reentrantLock.lock();
        reentrantLock.unlock();
    }

}

