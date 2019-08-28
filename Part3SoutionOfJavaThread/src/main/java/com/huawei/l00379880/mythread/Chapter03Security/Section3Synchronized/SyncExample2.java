/***********************************************************
 * @Description : 同步的例子1,修饰一个静态方法/类，适用于所有方法
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/7/16 00:19
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package com.huawei.l00379880.mythread.Chapter03Security.Section3Synchronized;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class SyncExample2 {
    /**
     * synchronized修饰类
     */
    public static void test1() {
        synchronized (SyncExample2.class) {
            for (int i = 0; i < 10; i++) {
                log.info("test1 - {}", i);
            }
            System.out.println();
        }
    }

    /**
     * synchronized修饰静态方法，作用于所有的实例
     */
    public static synchronized void test2() {
        for (int i = 0; i < 10; i++) {
            log.info("test2 - {}", i);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SyncExample2 example1 = new SyncExample2();
        SyncExample2 example2 = new SyncExample2();
        ExecutorService executorService = Executors.newCachedThreadPool();

        // 由于同步块的作用，所以线程pool-1-thread-1 先输出0-9，然后pool-1-thread-2 再输出0-9
        executorService.execute(() -> {
            example1.test1();
        });
        executorService.execute(() -> {
            example2.test1();
        });

        // 由于静态同步方法作用于该类的所有对象，所以即便这里分别使用了不同对象进行调用也是同步的
        executorService.execute(() -> {
            example1.test2();
        });
        executorService.execute(() -> {
            example2.test2();
        });

        executorService.shutdown();
    }
}
