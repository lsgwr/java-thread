package com.huawei.l00379880.mythread.Chapter08JUCThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/***********************************************************
 * @note      : 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待
 * @author    : l00379880 梁山广
 * @version   : V1.0 at 2019/9/4 16:31
 ***********************************************************/
public class ExecutorsNewFixedThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(3);
        // 若使用ThreadPoolExecutor里的方法，则需要进行强转
        // ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool();

        for (int i = 0; i < 10; i++) {
            final int index = i;
            exec.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("task:" + index);
                }
            });
        }
        exec.shutdown();
    }
}
