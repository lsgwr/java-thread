package com.huawei.l00379880.mythread.Chapter02Prepare;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.*;

/***********************************************************
 * @note      : CyclicBarrier测试让一组线程等待至某个状态之后再全部同时执行
 * 叫做回环是因为当所有等待线程都被释放以后，CyclicBarrier可以被重用
 * @author    : l00379880 梁山广
 * @version   : V1.0 at 2019/8/27 11:49
 ***********************************************************/

@Slf4j
public class CyclicBarrierBasicTest {
    public static void main(String[] args) {
        int N = 4;
        CyclicBarrier barrier = new CyclicBarrier(N);
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < N; ++i) {
            exec.execute(new CBTask(barrier));
        }
        exec.shutdown();
    }
}

/**
 * 输出结果是：
 * <p>
 * 11:54:26.162 [pool-1-thread-1] INFO com.huawei.l00379880.mythread.Chapter02Prepare.WriteTask - WriteTask-0开始写入数据...
 * 11:54:26.163 [pool-1-thread-4] INFO com.huawei.l00379880.mythread.Chapter02Prepare.WriteTask - WriteTask-3开始写入数据...
 * 11:54:26.163 [pool-1-thread-3] INFO com.huawei.l00379880.mythread.Chapter02Prepare.WriteTask - WriteTask-2开始写入数据...
 * 11:54:26.163 [pool-1-thread-2] INFO com.huawei.l00379880.mythread.Chapter02Prepare.WriteTask - WriteTask-1开始写入数据...
 * 11:54:26.733 [pool-1-thread-4] INFO com.huawei.l00379880.mythread.Chapter02Prepare.WriteTask - WriteTask-3写入数据完毕，等待其他线程写入完毕 1566878066733
 * 11:54:27.890 [pool-1-thread-3] INFO com.huawei.l00379880.mythread.Chapter02Prepare.WriteTask - WriteTask-2写入数据完毕，等待其他线程写入完毕 1566878067890
 * 11:54:28.060 [pool-1-thread-2] INFO com.huawei.l00379880.mythread.Chapter02Prepare.WriteTask - WriteTask-1写入数据完毕，等待其他线程写入完毕 1566878068060
 * 11:54:30.499 [pool-1-thread-1] INFO com.huawei.l00379880.mythread.Chapter02Prepare.WriteTask - WriteTask-0写入数据完毕，等待其他线程写入完毕 1566878070499
 * 11:54:30.499 [pool-1-thread-1] INFO com.huawei.l00379880.mythread.Chapter02Prepare.WriteTask - 所有任务写入完毕，继续处理其他任务... 1566878070499
 * 11:54:30.499 [pool-1-thread-4] INFO com.huawei.l00379880.mythread.Chapter02Prepare.WriteTask - 所有任务写入完毕，继续处理其他任务... 1566878070499
 * 11:54:30.499 [pool-1-thread-3] INFO com.huawei.l00379880.mythread.Chapter02Prepare.WriteTask - 所有任务写入完毕，继续处理其他任务... 1566878070499
 * 11:54:30.499 [pool-1-thread-2] INFO com.huawei.l00379880.mythread.Chapter02Prepare.WriteTask - 所有任务写入完毕，继续处理其他任务... 1566878070499
 */
