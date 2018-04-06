/***********************************************************
 * @Description : 利用原子基本数据类型类来实现++操作的原子性
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/6 下午10:26
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync.secondhalf;

import java.util.concurrent.atomic.AtomicInteger;

public class P127AddCountThread extends Thread {
    private AtomicInteger count = new AtomicInteger(0);

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println(count.incrementAndGet());
        }
    }
}
