/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/7/19 00:07
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package com.huawei.l00379880.mythread.Chapter05SecureObject.singleton;

import com.huawei.l00379880.mythread.annotations.ThreadRecommend;
import com.huawei.l00379880.mythread.annotations.ThreadSafe;

/**
 * 最安全的
 */
@ThreadSafe
@ThreadRecommend
public class SingletonExample7 {

    public SingletonExample7() {
    }

    public static SingletonExample7 getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton {
        INSTANCE;
        private SingletonExample7 singleton;

        Singleton() {
            singleton = new SingletonExample7();
        }

        public SingletonExample7 getInstance() {
            return singleton;
        }
    }
}
