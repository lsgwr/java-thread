package com.xdclass.communication.demo1;

public class Demo1 {

    private static volatile boolean flag = false;

    public static void main(String[] args) throws InterruptedException {

        Object obj = new Object();

        new Thread(()->{
            while (!flag) {
                synchronized (obj) {
                    try {
                        System.out.println("flag is false");
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            System.out.println("flag is true");
        }).start();

        new Thread(()->{
            while (!flag) {
                synchronized (obj) {
                    try {
                        System.out.println("flag is false");
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            System.out.println("flag is true");
        }).start();

        Thread.sleep(1000L);

        new Thread(()->{
            flag = true;
            synchronized (obj) {
                obj.notifyAll();
            }
        }).start();
    }

}
