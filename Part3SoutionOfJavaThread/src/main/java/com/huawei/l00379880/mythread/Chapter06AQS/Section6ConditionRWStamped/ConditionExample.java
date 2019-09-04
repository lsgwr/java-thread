/***********************************************************
 * @Description : 某个或者某些线程一起等待某个条件(Condition)
 * @author      : 梁山广(Liang Shan Guang)
 * @date        : 2019/9/4 07:44
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package com.huawei.l00379880.mythread.Chapter06AQS.Section6ConditionRWStamped;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionExample {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();

        // 线程1
        new Thread(() -> {
            try {
                // 线程1调用了lock方法，这时线程1就会加入到了AQS的等待队里面去
                reentrantLock.lock();
                // 1 等待信号
                System.out.println("线程1等待信号......");
                // 调用await方法后，线程1就会从AQS队列里移除，这里其实就已经释放了锁，然后线程1会马上进入到condition队列里面去，等待一个信号
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程1收到信号！");
            // 线程1释放锁，整个执行过程完毕！
            reentrantLock.unlock();
        }).start();

        new Thread(() -> {
            // 由于线程1中调用了await释放了锁的关系，所以线程2就会被唤醒获取到锁，加入到AQS等待队列中
            reentrantLock.lock();
            // 2 获取锁
            System.out.println("线程1获取锁");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 调用signalAll发送信号的方法，此时condition等待队列里线程1所在的节点元素就会被取出，然后重新放到AQS等待队列里（注意此时线程1还没有被唤醒）
            condition.signalAll();
            // 3 发送信号
            System.out.println("线程2发送信号");
            // 线程2释放锁，这时候AQS队列中只剩下线程1，然后AQS会按照从头到尾的顺序唤醒线程，于是线程1开始执行
            reentrantLock.unlock();
        }).start();
    }
}
