/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/3/18 下午7:36
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter1basic;

public class P25Run {
    public static void main(String[] args) {
        try {
            P25MyThread thread = new P25MyThread();
            thread.start();
            Thread.sleep(1000);
            thread.interrupt();
            // interruped是静态方法，所以判断的是当前执行interrupted()方法的线程是否停止。
            System.out.println("是否停止1?" + P25MyThread.interrupted());
            // 调用两次是因为interrupted()函数具有清除标志位的作用，连续调用两次的结果是相反地
            System.out.println("是否停止2?" + P25MyThread.interrupted());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
