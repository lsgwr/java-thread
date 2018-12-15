package com.xdclass.atomic.demo1;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * AtomicInteger Demo
 */
public class Demo1 {

    private static AtomicInteger sum = new AtomicInteger(0);

    public static void inCreate() {
        sum.incrementAndGet();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                for (int j = 0; j < 100; j++) {
                    inCreate();
                    System.out.println(sum);
                }
            }).start();

        }
    }
}
