package chapter9pool.section4CoreThreads;

/***********************************************************
 * @note      : LinkedBlockingQueue的初始化参数会导致异常
 * @author    : l00379880 梁山广
 * @version   : V1.0 at 2019/8/5 14:20
 ***********************************************************/

import java.util.concurrent.*;

/**
 * 线程池Demo
 * @author pc
 */
public class ThreadPoolDemo {

    public static void main(String[] args) throws InterruptedException {
        // 这里去掉了Queue的容量限制
        LinkedBlockingQueue<Runnable> objects = new LinkedBlockingQueue<>();
        // 1.预先把需要的线程加进去
        for (int i = 0; i < 100; i++) {
            objects.put(() -> {
                System.out.println(Thread.currentThread().getName());
            });
        }
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20, 3L, TimeUnit.SECONDS, objects);
        // 2.线程池先把预定义的进程都拉起来
        threadPoolExecutor.prestartAllCoreThreads();
    }
}

