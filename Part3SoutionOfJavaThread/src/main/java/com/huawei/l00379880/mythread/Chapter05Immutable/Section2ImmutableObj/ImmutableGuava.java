/***********************************************************
 * @Description : 谷歌的Guava实现不可变对象
 * @author      : 梁山广(Liang Shan Guang)
 * @date        : 2019/8/30 00:09
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package com.huawei.l00379880.mythread.Chapter05Immutable.Section2ImmutableObj;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

public class ImmutableGuava {
    private final static ImmutableList list = ImmutableList.of(1, 2, 3);

    private final static ImmutableSet set = ImmutableSet.copyOf(list);

    // map1和map2是等效的两种不同的初始化的方式
    private final static ImmutableMap<Integer, Integer> map1 = ImmutableMap.of(1, 2, 3, 4);
    private final static ImmutableMap<Integer, Integer> map2 = ImmutableMap.<Integer, Integer>builder()
            .put(1, 2)
            .put(3, 4)
            .build();

    public static void main(String[] args) {
        // 以下四行都会报如下错误，Exception in thread "main" java.lang.UnsupportedOperationException
        list.add(4);
        set.add(4);
        map1.put(1, 4);
        map2.put(1, 4);
    }
}
