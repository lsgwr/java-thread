/***********************************************************
 * @Description : 利用操作栈实现生产者和消费者交替执行
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 下午5:48
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3com;

import java.util.ArrayList;
import java.util.List;

public class P168MyStack {
    private List list = new ArrayList();

    synchronized public void push() {
        try {
            while (list.size() == 1) {
                this.wait();
            }
            list.add("anyString = " + Math.random());
            this.notifyAll();
            System.out.println("push = " + list.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public String pop() {
        String returnValue = "";
        try {
            while (list.size() == 0) {
                System.out.println("pop操作中的：" + Thread.currentThread().getName() + " 线程呈wait状态");
                this.wait();
            }
            returnValue = "" + list.get(0);
            list.remove(0);
            this.notifyAll();
            System.out.println("pop = " + list.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return returnValue;
    }
}
