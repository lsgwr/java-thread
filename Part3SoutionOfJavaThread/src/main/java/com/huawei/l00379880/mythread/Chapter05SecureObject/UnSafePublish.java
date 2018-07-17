/***********************************************************
 * @Description : 不安全的发布对象，
 * 发布对象：使一个对象能够被当前范围之外的代码所使用
 *
 * 1.什么叫不安全发布，发布之后的对象会被其他对象不安全的改变值

 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/7/17 08:12
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package com.huawei.l00379880.mythread.Chapter05SecureObject;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class UnSafePublish {
    @Getter
    private String[] states = {"a", "b", "c"};

    public static void main(String[] args) {
        UnSafePublish unSafePublish = new UnSafePublish();
        log.info("{}", Arrays.toString(unSafePublish.getStates()));
        unSafePublish.getStates()[0] = "d";
        log.info("{}", Arrays.toString(unSafePublish.getStates()));

    }
}
