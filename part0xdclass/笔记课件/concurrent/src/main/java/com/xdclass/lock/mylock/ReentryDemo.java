package com.xdclass.lock.mylock;

import java.util.concurrent.locks.Lock;

/**
 * 重入Demo
 */
public class ReentryDemo {

    public Lock lock = new MyLock();

    public void methodA() {
        lock.lock();
        System.out.println("进入方法A");
        methodB();
        lock.unlock();
    }

    public void methodB() {
        lock.lock();
        System.out.println("进入方法B");
        lock.unlock();
    }


    public static void main(String[] args) {
        ReentryDemo reentryDemo = new ReentryDemo();
        reentryDemo.methodA();
    }

}
