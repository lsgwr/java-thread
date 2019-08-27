package com.huawei.l00379880.mythread.Chapter02Prepare;

/***********************************************************
 * @note      : CountDownLatch等待功能测试
 * @author    : l00379880 梁山广
 * @version   : V1.0 at 2019/8/27 11:33
 ***********************************************************/

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
class Task implements Runnable {
    private static int count = 0;
    private final int id = count++;
    private final CountDownLatch latch;

    Task(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            log.info(this + "正在执行");
            TimeUnit.MILLISECONDS.sleep(3000);
            log.info(this + "执行完毕");
        } catch (InterruptedException e) {
            log.info(this + " 被中断");
        } finally {
            latch.countDown();
        }
    }

    @Override
    public String toString() {
        return "Task-" + id;
    }
}

/**
 * CountDownLatch功能测试
 *
 * @author l00379880
 */
@Slf4j
public class CountDownLatchTest {
    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(2);
        ExecutorService exec = Executors.newCachedThreadPool();

        exec.execute(new Task(latch));
        exec.execute(new Task(latch));

        try {
            log.info("等待2个子线程执行完毕...");
            long start = System.currentTimeMillis();
            latch.await();
            long end = System.currentTimeMillis();

            log.info("2个子线程已经执行完毕 " + (end - start));
            log.info("继续执行主线程");
        } catch (InterruptedException e) {
            log.info("主线程被中断");
        }
        exec.shutdown();
    }
}

/**
 * 输出结果：
 * <p>
 * 11:40:14.320 [main] INFO com.huawei.l00379880.mythread.Chapter02Prepare.CountDownLatchTest - 等待2个子线程执行完毕...
 * 11:40:14.321 [pool-1-thread-2] INFO com.huawei.l00379880.mythread.Chapter02Prepare.Task - Task-1正在执行
 * 11:40:14.321 [pool-1-thread-1] INFO com.huawei.l00379880.mythread.Chapter02Prepare.Task - Task-0正在执行
 * 11:40:17.679 [pool-1-thread-1] INFO com.huawei.l00379880.mythread.Chapter02Prepare.Task - Task-0执行完毕
 * 11:40:17.679 [pool-1-thread-2] INFO com.huawei.l00379880.mythread.Chapter02Prepare.Task - Task-1执行完毕
 * 11:40:17.679 [main] INFO com.huawei.l00379880.mythread.Chapter02Prepare.CountDownLatchTest - 2个子线程已经执行完毕 3346
 * 11:40:17.679 [main] INFO com.huawei.l00379880.mythread.Chapter02Prepare.CountDownLatchTest - 继续执行主线程
 */
