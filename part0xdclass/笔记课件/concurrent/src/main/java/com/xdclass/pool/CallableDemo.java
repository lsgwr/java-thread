package com.xdclass.pool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableDemo implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(3000L);
        return "1111";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableDemo callableDemo = new CallableDemo();
        FutureTask<String> stringFutureTask = new FutureTask<>(callableDemo);
        new Thread(stringFutureTask).start();
        System.out.println(stringFutureTask.get());
    }
}
