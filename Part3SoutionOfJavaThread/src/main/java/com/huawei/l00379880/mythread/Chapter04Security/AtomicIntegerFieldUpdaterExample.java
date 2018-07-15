/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/7/15 21:51
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package com.huawei.l00379880.mythread.Chapter04Security;

import com.huawei.l00379880.mythread.annotations.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

@Slf4j
@ThreadSafe
public class AtomicIntegerFieldUpdaterExample {
    private static AtomicIntegerFieldUpdater<AtomicIntegerFieldUpdaterExample> updater = AtomicIntegerFieldUpdater.newUpdater(AtomicIntegerFieldUpdaterExample.class, "count");
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
