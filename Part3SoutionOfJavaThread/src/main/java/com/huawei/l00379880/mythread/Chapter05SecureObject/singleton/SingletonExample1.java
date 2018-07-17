/***********************************************************
 * @Description : 第一种安全发布对象的单例模式：懒汉模式(第一次使用的时候创建),线程不安全
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/7/18 00:13
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package com.huawei.l00379880.mythread.Chapter05SecureObject.singleton;

import com.huawei.l00379880.mythread.annotations.ThreadNotSafe;

@ThreadNotSafe
public class SingletonExample1 {
    /**
     * 私有构造函数
     */
    private SingletonExample1() {
    }

    /**
     * 单例对象
     */
    private static SingletonExample1 instance = null;

    /**
     * 静态工厂方法
     */
    public static SingletonExample1 getInstance() {
        if (instance == null) {
            instance = new SingletonExample1();
        }
        return instance;
    }
}
