package com.xdclass.thread.demo2;

/**
 * 匿名内部类的方式
 */
public class MyThread {

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
        thread.start();
    }

}
