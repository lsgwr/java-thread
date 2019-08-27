/***********************************************************
 * @Description : AtomicReference和AtomicInteger非常类似，不同之处就在于AtomicInteger是对整数的封装，而AtomicReference
 * 是对对象引用的封装，AtomicReference用于保证对象引用的原子性。AtomicReference的用法同AtomicInteger一样，只不过是可以放各种对象
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2019/8/28 21:51
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package com.huawei.l00379880.mythread.Chapter03Security.Section2Atomic2;

import com.huawei.l00379880.mythread.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicReference;

@Slf4j
@ThreadSafe
public class AtomicReferenceExample {
    private static AtomicReference<Integer> count = new AtomicReference<>(0);

    public static void main(String[] args) {
        // 2
        count.compareAndSet(0, 2);
        // no
        count.compareAndSet(0, 1);
        // no
        count.compareAndSet(1, 3);
        // 4,最终结果
        count.compareAndSet(2, 4);
        // no
        count.compareAndSet(3, 5);
        log.info("count:{}", count.get());
    }
}
