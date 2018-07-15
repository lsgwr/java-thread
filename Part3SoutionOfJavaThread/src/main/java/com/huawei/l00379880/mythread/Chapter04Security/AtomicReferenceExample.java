/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/7/15 21:51
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package com.huawei.l00379880.mythread.Chapter04Security;

import java.util.concurrent.atomic.AtomicReference;

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
        count.compareAndSet(3, 4);
    }
}
