/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 下午12:39
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3com;

public class P144Service {
    public void testMethod(Object lock) {
        try {
            synchronized (lock) {
                System.out.println("begin wait() threadName = " + Thread.currentThread().getName());
                lock.wait();
                System.out.println("  end wait() threadName = " + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void synNotifyMethod(Object lock) {
        try {
            synchronized (lock) {
                System.out.println("begin notify() ThreadName = " + Thread.currentThread().getName() + ", time = " + System.currentTimeMillis());
                lock.notify();
                Thread.sleep(5000);
                System.out.println("  end notify() ThreadName = " + Thread.currentThread().getName() + ", time = " + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
