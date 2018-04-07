/***********************************************************
 * @Description : wait锁释放与notify锁不释放
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 下午12:01
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3com;

public class P143Service {
    public void testMethod(Object lock) {
        try {
            synchronized (lock) {
                System.out.println("begin wait()");
                // 进入wait后会释放锁
                lock.wait();
                System.out.println("  end wait");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
