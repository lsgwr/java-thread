/***********************************************************
 * @Description : 同步的例子1,修饰一个代码块
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/7/16 00:19
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package com.huawei.l00379880.mythread.Chapter03Security.Section3Synchronized;

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
            System.out.println();
        }
    }

    /**
     * synchronized修饰方法
     * 子类继承父类，想调用父类的synchronized方法的话，是带不上synchronized关键字的
     * * 原因：synchronized 不属于方法声明的一部分
     * * 如果子类也想使用同步需要在方法上声明
     */
    public synchronized void test2() {
        for (int i = 0; i < 10; i++) {
            log.info("test2 - {}", i);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SyncExample1 example1 = new SyncExample1();
        SyncExample1 example2 = new SyncExample1();
        // 使用线程池模拟多线程同时调用一段sync代码
        ExecutorService executorService = Executors.newCachedThreadPool();

        // 由于同步代码块的作用，所以线程1线输出0-9然后线程2再输出0-9
        executorService.execute(example1::test1);
        executorService.execute(example1::test1);

        // 由于同步方法只作用域该方法的对象，而这里分别使用了不同对象进行调用，所以线程1和线程2是交叉输出地
        executorService.execute(example1::test2);
        executorService.execute(example2::test2);

        // 关闭线程池
        executorService.shutdown();
    }
}

/**
 * 07:39:36.117 [pool-1-thread-4] INFO com.huawei.l00379880.mythread.Chapter03Security.Section3Synchronized.SyncExample1 - test2 - 0
 * 07:39:36.117 [pool-1-thread-1] INFO com.huawei.l00379880.mythread.Chapter03Security.Section3Synchronized.SyncExample1 - test1 - 0
 * 07:39:36.125 [pool-1-thread-4] INFO com.huawei.l00379880.mythread.Chapter03Security.Section3Synchronized.SyncExample1 - test2 - 1
 * 07:39:36.125 [pool-1-thread-1] INFO com.huawei.l00379880.mythread.Chapter03Security.Section3Synchronized.SyncExample1 - test1 - 1
 * 07:39:36.125 [pool-1-thread-4] INFO com.huawei.l00379880.mythread.Chapter03Security.Section3Synchronized.SyncExample1 - test2 - 2
 * 07:39:36.125 [pool-1-thread-1] INFO com.huawei.l00379880.mythread.Chapter03Security.Section3Synchronized.SyncExample1 - test1 - 2
 * 07:39:36.125 [pool-1-thread-4] INFO com.huawei.l00379880.mythread.Chapter03Security.Section3Synchronized.SyncExample1 - test2 - 3
 * 07:39:36.125 [pool-1-thread-1] INFO com.huawei.l00379880.mythread.Chapter03Security.Section3Synchronized.SyncExample1 - test1 - 3
 * 07:39:36.125 [pool-1-thread-4] INFO com.huawei.l00379880.mythread.Chapter03Security.Section3Synchronized.SyncExample1 - test2 - 4
 * 07:39:36.125 [pool-1-thread-1] INFO com.huawei.l00379880.mythread.Chapter03Security.Section3Synchronized.SyncExample1 - test1 - 4
 * 07:39:36.125 [pool-1-thread-4] INFO com.huawei.l00379880.mythread.Chapter03Security.Section3Synchronized.SyncExample1 - test2 - 5
 * 07:39:36.125 [pool-1-thread-1] INFO com.huawei.l00379880.mythread.Chapter03Security.Section3Synchronized.SyncExample1 - test1 - 5
 * 07:39:36.125 [pool-1-thread-4] INFO com.huawei.l00379880.mythread.Chapter03Security.Section3Synchronized.SyncExample1 - test2 - 6
 * 07:39:36.125 [pool-1-thread-1] INFO com.huawei.l00379880.mythread.Chapter03Security.Section3Synchronized.SyncExample1 - test1 - 6
 * 07:39:36.125 [pool-1-thread-4] INFO com.huawei.l00379880.mythread.Chapter03Security.Section3Synchronized.SyncExample1 - test2 - 7
 * 07:39:36.125 [pool-1-thread-1] INFO com.huawei.l00379880.mythread.Chapter03Security.Section3Synchronized.SyncExample1 - test1 - 7
 * 07:39:36.125 [pool-1-thread-4] INFO com.huawei.l00379880.mythread.Chapter03Security.Section3Synchronized.SyncExample1 - test2 - 8
 * 07:39:36.125 [pool-1-thread-1] INFO com.huawei.l00379880.mythread.Chapter03Security.Section3Synchronized.SyncExample1 - test1 - 8
 * 07:39:36.125 [pool-1-thread-4] INFO com.huawei.l00379880.mythread.Chapter03Security.Section3Synchronized.SyncExample1 - test2 - 9
 * 07:39:36.125 [pool-1-thread-1] INFO com.huawei.l00379880.mythread.Chapter03Security.Section3Synchronized.SyncExample1 - test1 - 9
 *
 *
 * 07:39:36.126 [pool-1-thread-3] INFO com.huawei.l00379880.mythread.Chapter03Security.Section3Synchronized.SyncExample1 - test2 - 0
 * 07:39:36.126 [pool-1-thread-3] INFO com.huawei.l00379880.mythread.Chapter03Security.Section3Synchronized.SyncExample1 - test2 - 1
 * 07:39:36.126 [pool-1-thread-3] INFO com.huawei.l00379880.mythread.Chapter03Security.Section3Synchronized.SyncExample1 - test2 - 2
 * 07:39:36.126 [pool-1-thread-3] INFO com.huawei.l00379880.mythread.Chapter03Security.Section3Synchronized.SyncExample1 - test2 - 3
 * 07:39:36.126 [pool-1-thread-3] INFO com.huawei.l00379880.mythread.Chapter03Security.Section3Synchronized.SyncExample1 - test2 - 4
 * 07:39:36.126 [pool-1-thread-3] INFO com.huawei.l00379880.mythread.Chapter03Security.Section3Synchronized.SyncExample1 - test2 - 5
 * 07:39:36.126 [pool-1-thread-3] INFO com.huawei.l00379880.mythread.Chapter03Security.Section3Synchronized.SyncExample1 - test2 - 6
 * 07:39:36.126 [pool-1-thread-3] INFO com.huawei.l00379880.mythread.Chapter03Security.Section3Synchronized.SyncExample1 - test2 - 7
 * 07:39:36.126 [pool-1-thread-3] INFO com.huawei.l00379880.mythread.Chapter03Security.Section3Synchronized.SyncExample1 - test2 - 8
 * 07:39:36.126 [pool-1-thread-3] INFO com.huawei.l00379880.mythread.Chapter03Security.Section3Synchronized.SyncExample1 - test2 - 9
 *
 * 07:39:36.126 [pool-1-thread-2] INFO com.huawei.l00379880.mythread.Chapter03Security.Section3Synchronized.SyncExample1 - test1 - 0
 * 07:39:36.126 [pool-1-thread-2] INFO com.huawei.l00379880.mythread.Chapter03Security.Section3Synchronized.SyncExample1 - test1 - 1
 * 07:39:36.127 [pool-1-thread-2] INFO com.huawei.l00379880.mythread.Chapter03Security.Section3Synchronized.SyncExample1 - test1 - 2
 * 07:39:36.127 [pool-1-thread-2] INFO com.huawei.l00379880.mythread.Chapter03Security.Section3Synchronized.SyncExample1 - test1 - 3
 * 07:39:36.127 [pool-1-thread-2] INFO com.huawei.l00379880.mythread.Chapter03Security.Section3Synchronized.SyncExample1 - test1 - 4
 * 07:39:36.127 [pool-1-thread-2] INFO com.huawei.l00379880.mythread.Chapter03Security.Section3Synchronized.SyncExample1 - test1 - 5
 * 07:39:36.127 [pool-1-thread-2] INFO com.huawei.l00379880.mythread.Chapter03Security.Section3Synchronized.SyncExample1 - test1 - 6
 * 07:39:36.127 [pool-1-thread-2] INFO com.huawei.l00379880.mythread.Chapter03Security.Section3Synchronized.SyncExample1 - test1 - 7
 * 07:39:36.127 [pool-1-thread-2] INFO com.huawei.l00379880.mythread.Chapter03Security.Section3Synchronized.SyncExample1 - test1 - 8
 * 07:39:36.127 [pool-1-thread-2] INFO com.huawei.l00379880.mythread.Chapter03Security.Section3Synchronized.SyncExample1 - test1 - 9
 */