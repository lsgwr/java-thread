package com.huawei.l00379880.mythread.Chapter08JUCThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/***********************************************************
 * @note      : 创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程
 * @author    : l00379880 梁山广
 * @version   : V1.0 at 2019/9/4 16:31
 ***********************************************************/
public class ExecutorsNewCachedThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        // 若使用ThreadPoolExecutor里的方法，则需要进行强转
        // ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();

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
