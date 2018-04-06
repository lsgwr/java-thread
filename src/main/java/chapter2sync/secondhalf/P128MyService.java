/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/6 下午10:33
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync.secondhalf;

import java.util.concurrent.atomic.AtomicLong;

public class P128MyService {
    public static AtomicLong aiRef = new AtomicLong();

    synchronized public void addNum() {
        System.out.println(Thread.currentThread().getName() + "加了100之后的值是：" + aiRef.addAndGet(100));
        aiRef.addAndGet(1);
    }
}
