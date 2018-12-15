package com.xdclass.communication.demo1;

public class Demo {

    private static volatile boolean flag = false;

    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            while (!flag) {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("flag is false");
            }

            System.out.println("flag is true");
        }).start();

        Thread.sleep(1000L);

        new Thread(()->{
            flag = true;
        }).start();
    }

}
