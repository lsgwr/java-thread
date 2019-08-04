package com.xdclass.thread.demo;

import java.io.IOException;
import java.io.Serializable;

public class MyRunable implements Runnable,Serializable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunable());
        thread.setName("xdclass");
//        thread.start();
        thread.run();
    }
}
