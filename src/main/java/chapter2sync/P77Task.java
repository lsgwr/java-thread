/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/3/26 下午11:18
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync;

public class P77Task {
    public void doLongTimeTask() {
        for (int i = 0; i < 100; i++) {
            System.out.println("no synchronized threadName：" + Thread.currentThread().getName() + ", i = " + (i + 1));
        }
        System.out.println("");
        synchronized (this) {
            for (int i = 0; i < 100; i++) {
                System.out.println("   synchronized threadName：" + Thread.currentThread().getName() + ", i = " + (i + 1));
            }
        }
    }
}
