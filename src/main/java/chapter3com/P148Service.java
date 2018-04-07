/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 下午1:05
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3com;

public class P148Service {
    public void testMethod(Object lock) {
        try {
            synchronized (lock) {
                System.out.println("begin wait() threadName = " + Thread.currentThread().getName());
                lock.wait();
                System.out.println("  end wait() threadName = " + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("出现异常了！因为呈wait状态的线程被interrupt了！");
        }
    }
}
