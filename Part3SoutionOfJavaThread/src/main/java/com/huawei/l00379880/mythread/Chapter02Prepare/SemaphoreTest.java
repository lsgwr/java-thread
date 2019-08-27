package com.huawei.l00379880.mythread.Chapter02Prepare;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/***********************************************************
 * @note      : 信号量测试
 * @author    : l00379880 梁山广
 * @version   : V1.0 at 2019/8/27 14:54
 ***********************************************************/

@Slf4j
class Worker implements Runnable {

    private static int count = 0;
    private final int id = count++;
    private int finished = 0;
    private Random random = new Random(47);
    private Semaphore semaphore;

    public Worker(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                semaphore.acquire();
                log.info(this + "占用一个机器在生产...");
                TimeUnit.MILLISECONDS.sleep(random.nextInt(2000));
                synchronized (this) {
                    log.info("已经生产了" + (++finished) + "个产品，释放出机器");
                }
                semaphore.release();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "-" + id;
    }
}

@Slf4j
public class SemaphoreTest {
    public static void main(String[] args) {
        // 工人数
        int N = 8;
        // 机器数目(这里就是同时允许多少线程进行访问)
        Semaphore semaphore = new Semaphore(5);
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < N; i++) {
            exec.execute(new Worker(semaphore));
        }
        exec.shutdown();
    }
}

/**
 * 输出结果如下：可以看到机器的释放和占用是成对地
 * <p>
 * 15:11:16.273 [pool-1-thread-1] INFO com.huawei.l00379880.mythread.Chapter02Prepare.Worker - Worker-0占用一个机器在生产...
 * 15:11:16.282 [pool-1-thread-4] INFO com.huawei.l00379880.mythread.Chapter02Prepare.Worker - Worker-3占用一个机器在生产...
 * 15:11:16.282 [pool-1-thread-6] INFO com.huawei.l00379880.mythread.Chapter02Prepare.Worker - Worker-5占用一个机器在生产...
 * 15:11:16.274 [pool-1-thread-2] INFO com.huawei.l00379880.mythread.Chapter02Prepare.Worker - Worker-1占用一个机器在生产...
 * 15:11:16.282 [pool-1-thread-3] INFO com.huawei.l00379880.mythread.Chapter02Prepare.Worker - Worker-2占用一个机器在生产...
 * 15:11:17.543 [pool-1-thread-4] INFO com.huawei.l00379880.mythread.Chapter02Prepare.Worker - 已经生产了1个产品，释放出机器
 * 15:11:17.544 [pool-1-thread-4] INFO com.huawei.l00379880.mythread.Chapter02Prepare.Worker - Worker-3占用一个机器在生产...
 * 15:11:17.544 [pool-1-thread-6] INFO com.huawei.l00379880.mythread.Chapter02Prepare.Worker - 已经生产了1个产品，释放出机器
 * 15:11:17.544 [pool-1-thread-7] INFO com.huawei.l00379880.mythread.Chapter02Prepare.Worker - Worker-6占用一个机器在生产...
 * 15:11:17.544 [pool-1-thread-1] INFO com.huawei.l00379880.mythread.Chapter02Prepare.Worker - 已经生产了1个产品，释放出机器
 * 15:11:17.544 [pool-1-thread-1] INFO com.huawei.l00379880.mythread.Chapter02Prepare.Worker - Worker-0占用一个机器在生产...
 * 15:11:17.546 [pool-1-thread-2] INFO com.huawei.l00379880.mythread.Chapter02Prepare.Worker - 已经生产了1个产品，释放出机器
 * 15:11:17.546 [pool-1-thread-2] INFO com.huawei.l00379880.mythread.Chapter02Prepare.Worker - Worker-1占用一个机器在生产...
 * 15:11:17.546 [pool-1-thread-3] INFO com.huawei.l00379880.mythread.Chapter02Prepare.Worker - 已经生产了1个产品，释放出机器
 * 15:11:17.546 [pool-1-thread-3] INFO com.huawei.l00379880.mythread.Chapter02Prepare.Worker - Worker-2占用一个机器在生产...
 * 15:11:18.102 [pool-1-thread-4] INFO com.huawei.l00379880.mythread.Chapter02Prepare.Worker - 已经生产了2个产品，释放出机器
 * 15:11:18.102 [pool-1-thread-4] INFO com.huawei.l00379880.mythread.Chapter02Prepare.Worker - Worker-3占用一个机器在生产...
 * 15:11:18.102 [pool-1-thread-1] INFO com.huawei.l00379880.mythread.Chapter02Prepare.Worker - 已经生产了2个产品，释放出机器
 * 15:11:18.102 [pool-1-thread-1] INFO com.huawei.l00379880.mythread.Chapter02Prepare.Worker - Worker-0占用一个机器在生产...
 * 15:11:18.103 [pool-1-thread-2] INFO com.huawei.l00379880.mythread.Chapter02Prepare.Worker - 已经生产了2个产品，释放出机器
 */
