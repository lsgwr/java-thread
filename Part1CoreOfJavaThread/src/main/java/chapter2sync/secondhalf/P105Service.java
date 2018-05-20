/***********************************************************
 * @Description : 线程死锁问题的产生
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/6 下午6:19
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync.secondhalf;

public class P105Service {
    Object object1 = new Object();
    Object object2 = new Object();

    public void methodA() {
        synchronized (object1) {
            System.out.println("methodA begin");
            boolean isContinueRun = true;
            while (isContinueRun) {

            }
            System.out.println("methodA   end");
        }
    }

    public void methodB() {
        synchronized (object2) {
            System.out.println("methodB begin");
            System.out.println("methodB   end");
        }
    }
}
