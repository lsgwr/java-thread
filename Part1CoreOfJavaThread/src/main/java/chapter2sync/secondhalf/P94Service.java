/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/6 下午2:01
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync.secondhalf;

public class P94Service {
    public void testMethod1(P93MyObject object){
        synchronized (object){
            try {
                System.out.println("testMethod1 getLock Time = " + System.currentTimeMillis() + ", run ThreadName = " + Thread.currentThread().getName());
                Thread.sleep(5000);
                System.out.println("testMethod1 releaseLock Time = " + System.currentTimeMillis() + ", run ThreadName = " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
