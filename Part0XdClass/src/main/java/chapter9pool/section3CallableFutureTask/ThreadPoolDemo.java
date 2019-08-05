package main.java.chapter10pool;

/***********************************************************
 * @note      : LinkedBlockingQueue的初始化参数会导致异常
 * @author    : l00379880 梁山广
 * @version   : V1.0 at 2019/8/5 14:20
 ***********************************************************/

import java.util.concurrent.*;

/**
 * 线程池Demo
 */
public class ThreadPoolDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 这里去掉了Queue的容量限制
        LinkedBlockingQueue<Runnable> objects = new LinkedBlockingQueue<>();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20, 3L, TimeUnit.SECONDS, objects);
        Future<String> submit = null;
        for (int i = 0; i < 100; i++) {
            submit = threadPoolExecutor.submit(new CallableDemo());
        }
        for (int i = 0; i < 100; i++) {
            // 阻塞等待线程结果，全部100个线程执行完毕后统一输出结果
            System.out.println(submit.get());
        }
    }
}
