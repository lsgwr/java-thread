/***********************************************************
 * @Description : String的常量池缓存功能
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/6 下午6:07
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync.secondhalf;

public class P104Service {
    public static void print(Object object) {
        try {
            synchronized (object) {
                while (true) {
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(1000);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
