/***********************************************************
 * @Description : 同步不能被继承
 * @author      : 梁山广(Liang Shan Guang)
 * @date        : 2018/3/25 下午10:02
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync.firsthalf;

public class P70Main {
    synchronized public void serviceMethod() {
        try {
            System.out.println("main ThreadName = " + Thread.currentThread().getName() + ", time = " + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("main ThreadName = " + Thread.currentThread().getName() + ", time = " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
