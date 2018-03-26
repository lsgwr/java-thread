/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/3/26 下午11:06
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync;

public class P76Run {
    public static void main(String[] args) throws InterruptedException {
        P76Task task = new P76Task();
        P76MyThread1 thread1 = new P76MyThread1(task);
        thread1.start();
        P76MyThread2 thread2 = new P76MyThread2(task);
        thread2.start();
        Thread.sleep(10000);
        long beginTime = Math.min(P72CommonUtils.beginTime1, P72CommonUtils.beginTime2);
        long endTime = Math.max(P72CommonUtils.endTime1, P72CommonUtils.endTime2);
        System.out.println("耗时：" + ((endTime - beginTime) / 1000));
    }
}
