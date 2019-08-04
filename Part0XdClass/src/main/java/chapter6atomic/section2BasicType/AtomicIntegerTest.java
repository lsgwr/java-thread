/***********************************************************
 * @Description : 原子整型类测试
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2019-08-05 00:06
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter6atomic.section2BasicType;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {
    /**
     * 原子整型类实例
     */
    private static AtomicInteger sum = new AtomicInteger(0);

    public static void inCreate() {
        sum.getAndIncrement();
    }

    /**
     * 原子操作，跑多少次都是输出1000
     *
     * @param args
     */
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    inCreate();
                    System.out.println(sum);
                }
            }).start();
        }
    }
}
