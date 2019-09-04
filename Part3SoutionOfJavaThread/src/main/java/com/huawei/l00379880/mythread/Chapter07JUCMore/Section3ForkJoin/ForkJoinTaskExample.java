package com.huawei.l00379880.mythread.Chapter07JUCMore.Section3ForkJoin;

import java.util.concurrent.*;

/***********************************************************
 * @note      : Fork-Join使用示例，完成1+2+3+4...+n的计算
 * @author    : l00379880 梁山广
 * @version   : V1.0 at 2019/9/4 11:18
 ***********************************************************/
public class ForkJoinTaskExample extends RecursiveTask<Integer> {
    private static final int THRESHHOLD = 2;
    private int start;
    private int end;

    public ForkJoinTaskExample(int start, int end) {
        this.start = start;
        this.end = end;
    }


    @Override
    protected Integer compute() {
        int sum = 0;

        // 如果任务足够小就直接计算任务
        boolean canCompute = (end - start) <= THRESHHOLD;
        if (canCompute) {
            for (int i = start; i <= end; i++) {
                sum += i;
            }
        } else {
            // 如果任务大于阈值，就分裂成两个子任务计算
            int middle = (start + end) / 2;
            ForkJoinTaskExample lesfTask = new ForkJoinTaskExample(start, middle);
            ForkJoinTaskExample rightTask = new ForkJoinTaskExample(middle + 1, end);

            // 执行子任务
            lesfTask.fork();
            rightTask.fork();

            // 等待子任务执行结束合并其结果
            int leftResult = lesfTask.join();
            int rightResult = rightTask.join();

            // 合并子任务
            sum = leftResult + rightResult;
        }
        return sum;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        // 生成一个计算任务, 计算1+2+3+4...+100
        ForkJoinTaskExample task = new ForkJoinTaskExample(1, 100);

        // 执行一个任务
        Future<Integer> result = forkJoinPool.submit(task);
        // 阻塞等待计算完毕
        System.out.println("并行计算结果是："+result.get());
    }
}
