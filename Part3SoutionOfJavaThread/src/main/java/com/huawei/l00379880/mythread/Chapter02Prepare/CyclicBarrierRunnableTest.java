package com.huawei.l00379880.mythread.Chapter02Prepare;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.*;

/***********************************************************
 * @note      : CyclicBarrier测试让一组线程等待至某个状态之后再全部同时执行
 * 叫做回环是因为当所有等待线程都被释放以后，CyclicBarrier可以被重用
 *
 * 在所有线程写入操作完之后，进行额外的其他操作可以为CyclicBarrier提供Runnable参数
 * @author    : l00379880 梁山广
 * @version   : V1.0 at 2019/8/27 11:49
 ***********************************************************/

@Slf4j
public class CyclicBarrierRunnableTest {
    public static void main(String[] args) {
        int N = 4;
        CyclicBarrier barrier = new CyclicBarrier(N, new Runnable() {
            @Override
            public void run() {
                log.info(String.valueOf(Thread.currentThread()));
            }
        });
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < N; ++i) {
            exec.execute(new CBTask(barrier));
        }
        exec.shutdown();
    }
}

/**
 * 输出结果是(从结果可以看出，当四个线程都到达barrier状态后，会从四个线程中选择一个线程去执行Runnable)：
 *
 * 12:11:53.501 [pool-1-thread-2] INFO com.huawei.l00379880.mythread.Chapter02Prepare.WriteTask - WriteTask-1开始写入数据...
 * 12:11:53.505 [pool-1-thread-3] INFO com.huawei.l00379880.mythread.Chapter02Prepare.WriteTask - WriteTask-2开始写入数据...
 * 12:11:53.507 [pool-1-thread-4] INFO com.huawei.l00379880.mythread.Chapter02Prepare.WriteTask - WriteTask-3开始写入数据...
 * 12:11:53.508 [pool-1-thread-1] INFO com.huawei.l00379880.mythread.Chapter02Prepare.WriteTask - WriteTask-0开始写入数据...
 * 12:11:54.067 [pool-1-thread-3] INFO com.huawei.l00379880.mythread.Chapter02Prepare.WriteTask - WriteTask-2写入数据完毕，等待其他线程写入完毕 1566879114067
 * 12:11:55.217 [pool-1-thread-4] INFO com.huawei.l00379880.mythread.Chapter02Prepare.WriteTask - WriteTask-3写入数据完毕，等待其他线程写入完毕 1566879115217
 * 12:11:55.388 [pool-1-thread-1] INFO com.huawei.l00379880.mythread.Chapter02Prepare.WriteTask - WriteTask-0写入数据完毕，等待其他线程写入完毕 1566879115388
 * 12:11:57.807 [pool-1-thread-2] INFO com.huawei.l00379880.mythread.Chapter02Prepare.WriteTask - WriteTask-1写入数据完毕，等待其他线程写入完毕 1566879117807
 * ### 备注： 从这里可以看出，当四个线程都到达barrier状态后，会从四个线程中选择一个线程去执行Runnable
 * 12:11:57.807 [pool-1-thread-2] INFO com.huawei.l00379880.mythread.Chapter02Prepare.CyclicBarrierRunnableTest - Thread[pool-1-thread-2,5,main]
 * 12:11:57.807 [pool-1-thread-2] INFO com.huawei.l00379880.mythread.Chapter02Prepare.WriteTask - 所有任务写入完毕，继续处理其他任务... 1566879117807
 * 12:11:57.807 [pool-1-thread-3] INFO com.huawei.l00379880.mythread.Chapter02Prepare.WriteTask - 所有任务写入完毕，继续处理其他任务... 1566879117807
 * 12:11:57.807 [pool-1-thread-4] INFO com.huawei.l00379880.mythread.Chapter02Prepare.WriteTask - 所有任务写入完毕，继续处理其他任务... 1566879117807
 * 12:11:57.807 [pool-1-thread-1] INFO com.huawei.l00379880.mythread.Chapter02Prepare.WriteTask - 所有任务写入完毕，继续处理其他任务... 1566879117807
 */
