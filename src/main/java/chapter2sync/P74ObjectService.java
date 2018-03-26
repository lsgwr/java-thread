/***********************************************************
 * @Description : 同步代码块的使用
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/3/26 下午10:39
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync;

public class P74ObjectService {
    public void serviceMethod() {
        try {
            synchronized (this) {
                System.out.println("begin time = " + System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println("end   time = " + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
