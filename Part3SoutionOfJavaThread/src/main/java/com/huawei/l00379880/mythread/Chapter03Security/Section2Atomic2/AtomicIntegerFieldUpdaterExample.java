/***********************************************************
 * @Description : AtomicReferenceFieldUpdater有基本类型的实现，例如AtomicIntegerFieldUpdater ，
 * 它们的核心作用是可以原子性的去更新某一个类的实例里所指定的某一个字段。AtomicReferenceFieldUpdater
 * 可以原子性的更新对象类型的字段，而AtomicIntegerFieldUpdater 则只可以更新整型字段
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2019/8/28 21:51
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package com.huawei.l00379880.mythread.Chapter03Security.Section2Atomic2;

import com.huawei.l00379880.mythread.annotations.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

@Slf4j
@ThreadSafe
public class AtomicIntegerFieldUpdaterExample {
    private static AtomicIntegerFieldUpdater<AtomicIntegerFieldUpdaterExample> updater = AtomicIntegerFieldUpdater.newUpdater(AtomicIntegerFieldUpdaterExample.class, "count");

    /**
     * volatile而且不能是static
     */
    @Getter
    public volatile int count = 100;

    public static void main(String[] args) {
        AtomicIntegerFieldUpdaterExample example = new AtomicIntegerFieldUpdaterExample();
        if (updater.compareAndSet(example, 100, 120)) {
            log.info("update success, {}", example.getCount());
        } else {
            log.info("update failed, {}", example.getCount());
        }
        if (updater.compareAndSet(example, 100, 120)) {
            log.info("update success, {}", example.getCount());
        } else {
            log.info("update failed, {}", example.getCount());
        }
    }
}
