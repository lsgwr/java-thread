/***********************************************************
 * @Description : 第一种安全发布对象的单例模式：懒汉模式(第一次使用的时候创建),
 *                通过加synchronized使得线程安全,但是不推荐，因为会降低性能
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/7/18 00:39
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package com.huawei.l00379880.mythread.Chapter04SecureObject.singleton;

import com.huawei.l00379880.mythread.annotations.ThreadNotRecommend;
import com.huawei.l00379880.mythread.annotations.ThreadSafe;

@ThreadSafe
@ThreadNotRecommend
public class SingletonExample3 {
    /**
     * 私有构造函数
     */
    private SingletonExample3() {
    }

    /**
     * 单例对象
     */
    private static SingletonExample3 instance = null;

    /**
     * 静态工厂方法,加上了同步，可以保证安全
     */
    public static synchronized SingletonExample3 getInstance() {
        if (instance == null) {
            instance = new SingletonExample3();
        }
        return instance;
    }
}
