/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 下午12:53
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3com;

public class P146Test {
    public static void main(String[] args) {
        Object lock = new Object();
        P145ThreadA a = new P145ThreadA(lock);
        a.start();
        P145NotifyThread notifyThread = new P145NotifyThread(lock);
        notifyThread.start();
        P146SynNotifyThread synNotifyThread = new P146SynNotifyThread(lock);
        synNotifyThread.start();
    }
}
