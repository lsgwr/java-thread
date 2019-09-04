package com.huawei.l00379880.mythread.Chapter08JUCThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/***********************************************************
 * @note      : 创建一个定长线程池，支持定时及周期性任务执行
 * @author    : l00379880 梁山广
 * @version   : V1.0 at 2019/9/4 16:31
 ***********************************************************/
public class ExecutorsNewSingleThreadExecutorDemo {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        // 若使用ThreadPoolExecutor里的方法，则需要进行强转
        // ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newSingleThreadExecutor();

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
