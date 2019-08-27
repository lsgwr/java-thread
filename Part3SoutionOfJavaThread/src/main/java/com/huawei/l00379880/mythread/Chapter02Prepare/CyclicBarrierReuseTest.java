package com.huawei.l00379880.mythread.Chapter02Prepare;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/***********************************************************
 * @note      : CyclicBarrier测试让一组线程等待至某个状态之后再全部同时执行
 * 叫做回环是因为当所有等待线程都被释放以后，CyclicBarrier可以被重用
 *
 * 在所有线程写入操作完之后，进行额外的其他操作可以为CyclicBarrier提供Runnable参数
 * @author    : l00379880 梁山广
 * @version   : V1.0 at 2019/8/27 11:49
 ***********************************************************/
@Slf4j
class CyclicBarrierManager implements Runnable {
    private CyclicBarrier barrier;

    public CyclicBarrierManager(CyclicBarrier barrier, ExecutorService exec, int N) {
        this.barrier = barrier;
        for (int i = 0; i < N - 1; ++i) {
            // 可重入的Task
            exec.execute(new CBTaskReuse(barrier));
        }
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                barrier.await();
            } catch (InterruptedException e) {
                log.info(getClass().getSimpleName() + " 被中断了！");
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

@Slf4j
public class CyclicBarrierReuseTest {
    public static void main(String[] args) {
        int N = 4;
        CyclicBarrier barrier = new CyclicBarrier(N);
        ExecutorService exec = Executors.newCachedThreadPool();
        // 在所有的线程执行完后
        exec.execute(new CyclicBarrierManager(barrier, exec, N));
        exec.shutdown();
    }
}

/**
 * 输出结果是(从结果可以看出，三个TaskReuse执行完后又开始重新执行，会一直反复执行下去
 * 可见CyclicBarrier是可以重用的,即当所有等待线程都被释放以后，CyclicBarrier可以被重新用作状态控制器)：
 *
 * 14:32:06.248 [pool-1-thread-2] INFO com.huawei.l00379880.mythread.Chapter02Prepare.CBTaskReuse - CBTaskReuse-1开始写入数据...
 * 14:32:06.249 [pool-1-thread-3] INFO com.huawei.l00379880.mythread.Chapter02Prepare.CBTaskReuse - CBTaskReuse-2开始写入数据...
 * 14:32:06.248 [pool-1-thread-1] INFO com.huawei.l00379880.mythread.Chapter02Prepare.CBTaskReuse - CBTaskReuse-0开始写入数据...
 * 14:32:06.813 [pool-1-thread-3] INFO com.huawei.l00379880.mythread.Chapter02Prepare.CBTaskReuse - CBTaskReuse-2写入数据完毕，等待其他线程写入完毕 1566887526813
 * 14:32:07.961 [pool-1-thread-1] INFO com.huawei.l00379880.mythread.Chapter02Prepare.CBTaskReuse - CBTaskReuse-0写入数据完毕，等待其他线程写入完毕 1566887527961
 * 14:32:10.552 [pool-1-thread-2] INFO com.huawei.l00379880.mythread.Chapter02Prepare.CBTaskReuse - CBTaskReuse-1写入数据完毕，等待其他线程写入完毕 1566887530552
 * 14:32:10.552 [pool-1-thread-2] INFO com.huawei.l00379880.mythread.Chapter02Prepare.CBTaskReuse - 所有任务写入完毕，继续处理其他任务... 1566887530552
 * 14:32:10.552 [pool-1-thread-2] INFO com.huawei.l00379880.mythread.Chapter02Prepare.CBTaskReuse - CBTaskReuse-1开始写入数据...
 * 14:32:10.552 [pool-1-thread-3] INFO com.huawei.l00379880.mythread.Chapter02Prepare.CBTaskReuse - 所有任务写入完毕，继续处理其他任务... 1566887530552
 * 14:32:10.552 [pool-1-thread-1] INFO com.huawei.l00379880.mythread.Chapter02Prepare.CBTaskReuse - 所有任务写入完毕，继续处理其他任务... 1566887530552
 * 14:32:10.552 [pool-1-thread-3] INFO com.huawei.l00379880.mythread.Chapter02Prepare.CBTaskReuse - CBTaskReuse-2开始写入数据...
 * 14:32:10.552 [pool-1-thread-1] INFO com.huawei.l00379880.mythread.Chapter02Prepare.CBTaskReuse - CBTaskReuse-0开始写入数据...
 * 14:32:10.985 [pool-1-thread-1] INFO com.huawei.l00379880.mythread.Chapter02Prepare.CBTaskReuse - CBTaskReuse-0写入数据完毕，等待其他线程写入完毕 1566887530985
 * 14:32:11.523 [pool-1-thread-3] INFO com.huawei.l00379880.mythread.Chapter02Prepare.CBTaskReuse - CBTaskReuse-2写入数据完毕，等待其他线程写入完毕 1566887531523
 * 14:32:12.431 [pool-1-thread-2] INFO com.huawei.l00379880.mythread.Chapter02Prepare.CBTaskReuse - CBTaskReuse-1写入数据完毕，等待其他线程写入完毕 1566887532431
 * 14:32:12.431 [pool-1-thread-2] INFO com.huawei.l00379880.mythread.Chapter02Prepare.CBTaskReuse - 所有任务写入完毕，继续处理其他任务... 1566887532431
 * 14:32:12.431 [pool-1-thread-2] INFO com.huawei.l00379880.mythread.Chapter02Prepare.CBTaskReuse - CBTaskReuse-1开始写入数据...
 * 14:32:12.431 [pool-1-thread-1] INFO com.huawei.l00379880.mythread.Chapter02Prepare.CBTaskReuse - 所有任务写入完毕，继续处理其他任务... 1566887532431
 * 14:32:12.431 [pool-1-thread-3] INFO com.huawei.l00379880.mythread.Chapter02Prepare.CBTaskReuse - 所有任务写入完毕，继续处理其他任务... 1566887532431
 * 14:32:12.431 [pool-1-thread-1] INFO com.huawei.l00379880.mythread.Chapter02Prepare.CBTaskReuse - CBTaskReuse-0开始写入数据...
 * 14:32:12.432 [pool-1-thread-3] INFO com.huawei.l00379880.mythread.Chapter02Prepare.CBTaskReuse - CBTaskReuse-2开始写入数据...
 * 14:32:12.633 [pool-1-thread-1] INFO com.huawei.l00379880.mythread.Chapter02Prepare.CBTaskReuse - CBTaskReuse-0写入数据完毕，等待其他线程写入完毕 1566887532633
 * 14:32:16.998 [pool-1-thread-3] INFO com.huawei.l00379880.mythread.Chapter02Prepare.CBTaskReuse - CBTaskReuse-2写入数据完毕，等待其他线程写入完毕 1566887536998
 * 14:32:17.346 [pool-1-thread-2] INFO com.huawei.l00379880.mythread.Chapter02Prepare.CBTaskReuse - CBTaskReuse-1写入数据完毕，等待其他线程写入完毕 1566887537346
 * 14:32:17.346 [pool-1-thread-2] INFO com.huawei.l00379880.mythread.Chapter02Prepare.CBTaskReuse - 所有任务写入完毕，继续处理其他任务... 1566887537346
 * 14:32:17.346 [pool-1-thread-2] INFO com.huawei.l00379880.mythread.Chapter02Prepare.CBTaskReuse - CBTaskReuse-1开始写入数据...
 */
