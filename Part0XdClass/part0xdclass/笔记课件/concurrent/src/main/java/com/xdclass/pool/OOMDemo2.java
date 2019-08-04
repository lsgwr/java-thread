package com.xdclass.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OOMDemo2 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        while (true) {
            executorService.submit(() -> {
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
    
}
