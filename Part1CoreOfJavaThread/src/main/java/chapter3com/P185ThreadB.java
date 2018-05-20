/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 下午9:49
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3com;

public class P185ThreadB extends Thread {
    @Override
    public void run() {
        try {
            System.out.println(" b run begin time = " + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println(" b run   end time = " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public void bService() {
        System.out.println("打印了bService time = " + System.currentTimeMillis());
    }
}
