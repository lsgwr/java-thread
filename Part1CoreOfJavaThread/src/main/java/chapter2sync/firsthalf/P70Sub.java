/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/3/25 下午10:07
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync.firsthalf;

public class P70Sub extends P70Main {
    @Override
    public void serviceMethod() {
        try {
            System.out.println("sub ThreadName = " + Thread.currentThread().getName() + ", time = " + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("sub ThreadName = " + Thread.currentThread().getName() + ", time = " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
