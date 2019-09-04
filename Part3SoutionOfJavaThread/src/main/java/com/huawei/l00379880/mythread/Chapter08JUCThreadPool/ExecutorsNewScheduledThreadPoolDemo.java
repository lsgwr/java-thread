package com.huawei.l00379880.mythread.Chapter08JUCThreadPool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/***********************************************************
 * @note      : 创建一个定长线程池，支持定时及周期性任务执行
 * @author    : l00379880 梁山广
 * @version   : V1.0 at 2019/9/4 16:31
 ***********************************************************/
@Slf4j
public class ExecutorsNewScheduledThreadPoolDemo {
    public static void main(String[] args) {
        ScheduledExecutorService exec = Executors.newScheduledThreadPool(3);
        // 若使用ThreadPoolExecutor里的方法，则需要进行强转
        // ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newScheduledThreadPool();

        // 延迟3s执行
        exec.schedule(() -> log.info("schedule......"), 3, TimeUnit.SECONDS);

        // 以指定的速率执行任务，这里是每个3s执行一次人文与
        exec.scheduleAtFixedRate(() -> log.info("scheduleAtFixedRate......"), 1, 3, TimeUnit.SECONDS);

        // 以指定的延迟执行任务，这里是延迟3s执行一次任务，使用起来和scheduleAtFixedRate基本一样
        exec.scheduleWithFixedDelay(() -> log.info("scheduleWithFixedDelay......"), 1, 3, TimeUnit.SECONDS);

        // 想要定时任务能正常执行，不要关闭线程池
        // exec.shutdown();
    }
}
/**
 * 16:57:44.232 [pool-1-thread-1] INFO com.huawei.l00379880.mythread.Chapter08JUCThreadPool.ExecutorsNewScheduledThreadPoolDemo - scheduleAtFixedRate......
 * 16:57:44.237 [pool-1-thread-1] INFO com.huawei.l00379880.mythread.Chapter08JUCThreadPool.ExecutorsNewScheduledThreadPoolDemo - scheduleWithFixedDelay......
 * 16:57:46.161 [pool-1-thread-1] INFO com.huawei.l00379880.mythread.Chapter08JUCThreadPool.ExecutorsNewScheduledThreadPoolDemo - schedule......
 * 16:57:47.025 [pool-1-thread-2] INFO com.huawei.l00379880.mythread.Chapter08JUCThreadPool.ExecutorsNewScheduledThreadPoolDemo - scheduleAtFixedRate......
 * 16:57:47.032 [pool-1-thread-3] INFO com.huawei.l00379880.mythread.Chapter08JUCThreadPool.ExecutorsNewScheduledThreadPoolDemo - scheduleWithFixedDelay......
 * 16:57:49.959 [pool-1-thread-1] INFO com.huawei.l00379880.mythread.Chapter08JUCThreadPool.ExecutorsNewScheduledThreadPoolDemo - scheduleAtFixedRate......
 * 16:57:49.959 [pool-1-thread-2] INFO com.huawei.l00379880.mythread.Chapter08JUCThreadPool.ExecutorsNewScheduledThreadPoolDemo - scheduleWithFixedDelay......
 * 16:57:52.733 [pool-1-thread-1] INFO com.huawei.l00379880.mythread.Chapter08JUCThreadPool.ExecutorsNewScheduledThreadPoolDemo - scheduleAtFixedRate......
 * 16:57:52.741 [pool-1-thread-3] INFO com.huawei.l00379880.mythread.Chapter08JUCThreadPool.ExecutorsNewScheduledThreadPoolDemo - scheduleWithFixedDelay......
 * 16:57:55.512 [pool-1-thread-2] INFO com.huawei.l00379880.mythread.Chapter08JUCThreadPool.ExecutorsNewScheduledThreadPoolDemo - scheduleAtFixedRate......
 * 16:57:55.522 [pool-1-thread-1] INFO com.huawei.l00379880.mythread.Chapter08JUCThreadPool.ExecutorsNewScheduledThreadPoolDemo - scheduleWithFixedDelay......
 * 16:57:58.291 [pool-1-thread-3] INFO com.huawei.l00379880.mythread.Chapter08JUCThreadPool.ExecutorsNewScheduledThreadPoolDemo - scheduleAtFixedRate......
 * 16:57:58.297 [pool-1-thread-2] INFO com.huawei.l00379880.mythread.Chapter08JUCThreadPool.ExecutorsNewScheduledThreadPoolDemo - scheduleWithFixedDelay......
 */
