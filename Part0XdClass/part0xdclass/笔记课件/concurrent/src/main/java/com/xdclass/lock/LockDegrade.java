package com.xdclass.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 锁降级
 */
public class LockDegrade {

    public static void main(String[] args) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        Lock readLock = reentrantReadWriteLock.readLock();
        Lock writeLock = reentrantReadWriteLock.writeLock();


        readLock.lock();
        writeLock.lock();
        writeLock.unlock();
        readLock.unlock();

        System.out.println("程序运行结束");
    }
}
