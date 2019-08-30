/***********************************************************
 * @Description : 使用ThreadLocal实现登录用户的区分
 * @author      : 梁山广(Liang Shan Guang)
 * @date        : 2019/8/30 07:59
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package com.huawei.l00379880.mythread.Chapter05Immutable.Section3ThreadIsolate;

public class ThreadLocalRequestHolder {
    private final static ThreadLocal<Long> requestHolder = new ThreadLocal<>();


    public static void add(Long id) {
        // ThreadLocal 内部维护一个map，key为当前线程id，value为当前set的变量
        requestHolder.set(id);
    }

    /**
     * 会通过当前线程id获取数据
     */
    public static Long getId() {
        return requestHolder.get();
    }

    /**
     * 移除变量信息
     * 如果不移除，那么变量不会释放掉，会造成内存泄漏
     */
    public static void remove() {
        requestHolder.remove();
    }
}
