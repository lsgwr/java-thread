/***********************************************************
 * @Description : Collections.unmodifiableXXX测试
 * @author      : 梁山广(Liang Shan Guang)
 * @date        : 2019/8/29 23:44
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package com.huawei.l00379880.mythread.Chapter05Immutable.Section1ImmutableObj;

import com.google.common.collect.Maps;

import java.util.Collections;
import java.util.Map;

public class ImmutableCollections {
    private static Map<Integer, Integer> map = Maps.newHashMap();

    static {
        map.put(1, 2);
        map.put(3, 4);
        map.put(5, 6);
        // 用了Collections.unmodifiableXXX就不能用final修饰了
        map = Collections.unmodifiableMap(map);
    }

    public static void main(String[] args) {
        // h会报错，对象属性也不许修改了,Exception in thread "main" java.lang.UnsupportedOperationException
        map.put(1, 3);
        System.out.println(map.get(1));
    }
}
