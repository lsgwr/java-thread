/***********************************************************
 * @Description : 同步的例子1,修饰一个代码块
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/7/16 00:19
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package com.huawei.l00379880.mythread.Chapter04Security;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class SyncExample1 {
    /**
     * synchronized修饰代码块
     */
    public void test1() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                log.info("test1 - {}", i);
            }
        }
    }

    /**
     * synchronized修饰方法
     */
    public synchronized void test2() {
        for (int i = 0; i < 10; i++) {
            log.info("test2 - {}", i);
        }
    }

    public static void main(String[] args) {
        SyncExample1 example1 = new SyncExample1();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(()->{
            example1.test2();
        });
        executorService.execute(()->{
            example1.test2();
        });
    }
}
