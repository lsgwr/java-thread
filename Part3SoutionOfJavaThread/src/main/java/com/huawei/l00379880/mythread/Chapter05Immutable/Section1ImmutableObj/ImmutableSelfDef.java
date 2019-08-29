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

public class ImmutableSelfDef {
    private final static Integer a = 1;
    private final static String b = "2";
    private final static Map<Integer, Integer> map = Maps.newHashMap();

    static {
        // final修饰变量，变量不能重新赋值
        // a=2;
        // b="3";

        // final修饰对象，对象可以可以修改属性，但是不能指向其他对象
        map.put(1, 2);
        map.put(3, 4);
        map.put(5, 6);
        // final修饰后不能再指向另一个对象
        // map = Maps.newHashMap();
    }

    public static void main(String[] args) {

    }
}
