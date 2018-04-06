/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/6 下午5:48
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync.secondhalf;

public class P101Service {
    public static void printA() {
        synchronized (P101Service.class) {
            try {
                System.out.println("线程名称为：" + Thread.currentThread().getName() + "，在" + System.currentTimeMillis() + "进入printA");
                Thread.sleep(3000);
                System.out.println("线程名称为：" + Thread.currentThread().getName() + "，在" + System.currentTimeMillis() + "离开printA");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void printB() {
        synchronized (P101Service.class) {
            System.out.println("线程名称为：" + Thread.currentThread().getName() + "，在" + System.currentTimeMillis() + "进入printB");
            System.out.println("线程名称为：" + Thread.currentThread().getName() + "，在" + System.currentTimeMillis() + "离开printB");
        }
    }
}
