/***********************************************************
 * @Description : awaitUninterruptibly，等待过程中被interrupt时不报异常
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/9 下午11:52
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter4reen;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class P230Service {
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    public void testMethod(){
        try {
            lock.lock();
            System.out.println("wait begin");
            condition.awaitUninterruptibly();
            System.out.println("wait   end");
        } finally {
            lock.unlock();
        }
    }
}
