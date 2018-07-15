/***********************************************************
 * @Description : 线程可见性的问题
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/5/23 21:28
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package Chapter02TargetAndChallenge;

import util.Tools;

class TimeConsumingTask implements Runnable {

    private volatile boolean toCancel = false;

    private boolean doExecute() {
        boolean isDone = false;
        System.out.println("executing...");
        // 模拟实际操作的时间消耗
        Tools.randomPause(50);
        return isDone;
    }

    public void cancel() {
        toCancel = true;
        System.out.println(this + " canceled.");
    }

    @Override
    public void run() {
        while (!toCancel) {
            if (doExecute()) {
                break;
            }
        }
        if (toCancel) {
            System.out.println("Task is canceled.");
        } else {
            System.out.println("Task done.");
        }
    }
}

public class P49VisibilityDemo {
    public static void main(String[] args) throws InterruptedException {
        TimeConsumingTask timeConsumingTask = new TimeConsumingTask();
        Thread thread = new Thread(timeConsumingTask);
        thread.start();
        // 指定的时间内任务没有执行结束的话，就将其取消
        Thread.sleep(1000);
        timeConsumingTask.cancel();
    }
}
