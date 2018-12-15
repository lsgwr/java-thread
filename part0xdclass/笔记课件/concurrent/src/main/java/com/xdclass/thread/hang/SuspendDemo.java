package com.xdclass.thread.hang;

/**
 * 挂起操作的Demo
 */
public class SuspendDemo implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"执行run方法，准备调用suspend方法");
        //挂起线程
        Thread.currentThread().suspend();
        System.out.println(Thread.currentThread().getName()+"执行run方法，调用suspend方法结束");

    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new SuspendDemo());
        thread.start();
        Thread.sleep(3000L);
        //对线程进行唤醒操作
        thread.resume();
    }
}
