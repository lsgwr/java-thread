/***********************************************************
 * @Description : join(long)是设置等待的时间
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 下午9:39
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3com;

public class P183MyThread extends Thread{
    @Override
    public void run() {
        try {
            System.out.println("begin time = "+System.currentTimeMillis());
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
