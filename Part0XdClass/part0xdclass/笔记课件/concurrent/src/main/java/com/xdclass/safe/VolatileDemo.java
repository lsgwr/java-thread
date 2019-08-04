package com.xdclass.safe;

/**
 * volatile关键字Demo
 */
public class VolatileDemo implements Runnable {

    private static volatile boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {

    }


}
