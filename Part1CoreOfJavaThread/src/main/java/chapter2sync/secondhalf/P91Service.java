/***********************************************************
 * @Description : 多个线程同时执行synchronized(x){}同步代码块时
 *                呈同步效果
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/6 下午1:39
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync.secondhalf;

public class P91Service {
    public void testMethod1(P91MyObject object) {
        try {
            synchronized (object) {
                System.out.println("testMethod1 getLock Time = " + System.currentTimeMillis() + ", run ThreadName = " + Thread.currentThread().getName());
                Thread.sleep(2000);
                System.out.println("testMethod1 releaseLock Time = " + System.currentTimeMillis() + ", run ThreadName = " + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
