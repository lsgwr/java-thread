/***********************************************************
 * @Description : synchronized(this)和synchronized都是锁定当前对象地
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/3/28 下午11:43
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync.firsthalf;

public class P80Task {
    public synchronized void otherMethod() {
        System.out.println("---------------------------------run--otherMethod");
    }

    public void doLongTimeTask() {
        synchronized (this) {
            for (int i = 0; i < 10000; i++) {
                System.out.println("synchronized threadName = " + Thread.currentThread().getName() + ", i = " + (i + 1));
            }
        }
    }
}
