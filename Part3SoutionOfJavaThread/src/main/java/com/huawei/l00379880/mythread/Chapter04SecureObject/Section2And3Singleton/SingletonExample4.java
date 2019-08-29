/***********************************************************
 * @Description : 第一种安全发布对象的单例模式：懒汉模式(第一次使用的时候创建),
 *                通过加synchronized使得线程安全,但是不推荐，因为会降低性能
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/7/18 00:39
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package com.huawei.l00379880.mythread.Chapter04SecureObject.Section2And3Singleton;

import com.huawei.l00379880.mythread.annotations.ThreadNotRecommend;
import com.huawei.l00379880.mythread.annotations.ThreadNotSafe;

@ThreadNotSafe
@ThreadNotRecommend
public class SingletonExample4 {
    /**
     * 私有构造函数
     */
    private SingletonExample4() {
    }

    /**
     * 单例对象
     */
    private static SingletonExample4 instance = null;

    /**
     * 静态工厂方法,加上了代码块同步，可以保证安全,并且可以减少性能损耗(双重同步锁单例模式)
     * 但是仍然是线程不安全的，这个要从内存分配说起，new分好几步，可能导致线程不安全
     */
    public static synchronized SingletonExample4 getInstance() {
        // 双重检测机制
        if (instance == null) {
            synchronized (SingletonExample4.class) {
                if (instance == null) {
                    instance = new SingletonExample4();
                }
            }
        }
        return instance;
    }
}
