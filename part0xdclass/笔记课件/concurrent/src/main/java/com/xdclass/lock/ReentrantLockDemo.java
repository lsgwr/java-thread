package com.xdclass.lock;

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
