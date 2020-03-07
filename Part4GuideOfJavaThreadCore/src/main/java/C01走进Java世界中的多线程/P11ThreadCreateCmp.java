/***********************************************************
 * @Description : 线程的两种创建方式的区别
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/5/21 22:54
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package C01走进Java世界中的多线程;

import util.Tools;

public class P11ThreadCreateCmp {
    static class Counter {
        private int count = 0;

        public void increment() {
            count++;
        }

        public int value() {
            return count;
        }
    }

    static class CountingTask implements Runnable {
        private Counter counter = new Counter();

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                doSomething();
                counter.increment();
            }
            System.out.println("CountingTask : " + counter.value());
        }

        private void doSomething() {
            // 使当前线程休眠随机时间
            Tools.randomPause(80);
        }
    }

    static class CountingThread extends Thread {
        private Counter counter = new Counter();

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                doSomething();
                counter.increment();
            }
            System.out.println("CountingThread : " + counter.value());
        }

        private void doSomething() {
            // 使当前线程休眠随机时间
            Tools.randomPause(80);
        }
    }

    public static void main(String[] args) {
        Thread t;
        CountingTask ct = new CountingTask();
        // 获取处理器个数
        final int numberOfProcessors = Runtime.getRuntime().availableProcessors();
        for (int i = 0; i < 2 * numberOfProcessors; i++) {
            // 直接创建线程(传入实现了Runnable的类)
            t = new Thread(ct);
            t.start();
        }
        for (int i = 0; i < 2 * numberOfProcessors; i++) {
            // 以子类的方式创建线程
            t = new CountingThread();
            t.start();
        }
    }
}
/**
 * CountingThread : 100
 * CountingThread : 100
 * CountingTask : 1467
 * CountingThread : 100
 * CountingTask : 1486
 * CountingTask : 1497
 * CountingThread : 100
 * CountingThread : 100
 * CountingTask : 1515
 * CountingTask : 1518
 * CountingTask : 1520
 * CountingTask : 1529
 * CountingTask : 1546
 * CountingThread : 100
 * CountingThread : 100
 * CountingThread : 100
 * CountingTask : 1556
 * CountingThread : 100
 * CountingThread : 100
 * CountingThread : 100
 * CountingThread : 100
 * CountingThread : 100
 * CountingTask : 1567
 * CountingTask : 1574
 * CountingThread : 100
 * CountingThread : 100
 * CountingTask : 1582
 * CountingTask : 1583
 * CountingTask : 1584
 * CountingTask : 1585
 * CountingThread : 100
 * CountingTask : 1591
 */
