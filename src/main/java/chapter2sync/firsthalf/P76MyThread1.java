/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/3/25 下午10:35
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync.firsthalf;

public class P76MyThread1 extends Thread {
    private P76Task task;

    public P76MyThread1(P76Task task) {
        this.task = task;
    }

    @Override
    public void run() {
        P72CommonUtils.beginTime1 = System.currentTimeMillis();
        task.doLongTimeTask();
        P72CommonUtils.endTime1 = System.currentTimeMillis();
    }
}
