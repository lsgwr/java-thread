/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/3/28 下午11:46
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync;

public class P80MyThread2 extends Thread {
    private P80Task task;

    public P80MyThread2(P80Task task) {
        this.task = task;
    }

    @Override
    public void run() {
        task.otherMethod();
    }
}
