/***********************************************************
 * @Description : 竞态的Demo
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/5/22 23:10
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package C02多线程编程的目标与挑战;

import util.Tools;

public class P35RaceConditionDemo {

    /**
     * 模拟业务线程的类
     */
    static class WorkerThread extends Thread {
        private final int requestCount;

        public WorkerThread(int id, int requestCount) {
            super("worker-" + id);
            this.requestCount = requestCount;
        }

        @Override
        public void run() {
            int i = requestCount;
            String requestID;
            P34RequestIDGenerator requestIDGenerator = P34RequestIDGenerator.getINSTANCE();
            while (i-- > 0) {
                // 生成Request ID
                requestID = requestIDGenerator.nextID();
                processRequest(requestID);
            }
        }

        /**
         * 模拟请求处理
         */
        private void processRequest(String requestID) {
            // 模拟请求处理耗时
            Tools.randomPause(50);
            System.out.println(Thread.currentThread().getName() + "got requestID : " + requestID);
        }
    }

    public static void main(String[] args) {
        // 客户端线程数
        int numberOfThreads = args.length > 0 ? Short.valueOf(args[0]) : Runtime.getRuntime().availableProcessors();
        Thread[] workerThreads = new Thread[numberOfThreads];
        for (int i = 0; i < numberOfThreads; i++) {
            workerThreads[i] = new WorkerThread(i, 10);
        }
        // 待到所有线程创建完毕后，再一次性将其启动，以便这些线程能够尽可能地在同一时间运行
        for (Thread workerThread : workerThreads) {
            workerThread.start();
        }
    }
}
