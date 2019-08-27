package com.huawei.l00379880.mythread.Chapter02Prepare;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/***********************************************************
 * @note      :  CyclicBarrier的task
 * @author    : l00379880 梁山广
 * @version   : V1.0 at 2019/8/27 14:07
 ***********************************************************/

@Slf4j
public class CBTaskReuse implements Runnable {
    private static int count = 0;
    private final int id = count++;
    private CyclicBarrier barrier;
    private static Random random = new Random(47);

    public CBTaskReuse(CyclicBarrier cyclicBarrier) {
        this.barrier = cyclicBarrier;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            log.info(this + "开始写入数据...");
            try {
                //以睡眠来模拟写入数据操作
                TimeUnit.MILLISECONDS.sleep(random.nextInt(5000));
                log.info(this + "写入数据完毕，等待其他线程写入完毕" + " " + System.currentTimeMillis());
                // 等待CyclicBarrier里面的其他线程跑完在往下走
                barrier.await();
            } catch (InterruptedException e) {
                log.info(this + "is interrupted!");
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
            log.info("所有任务写入完毕，继续处理其他任务... " + System.currentTimeMillis());
        }

    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "-" + id;
    }
}
