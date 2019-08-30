package com.huawei.l00379880.mythread.Chapter05Immutable.Section6And7SynchronizedCollections;

import java.util.Vector;

/***********************************************************
 * @note      : Vector在循环中删除元素时可能会出现不安全的情况(越界错误)
 * @author    : l00379880 梁山广
 * @version   : V1.0 at 2019/8/30 10:34
 ***********************************************************/
public class VectorUnsafeExample {
    private static Vector<Integer> vector = new Vector<>();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            vector.add(i);
        }

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    vector.remove(i);
                }
            }
        };

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    vector.get(i);
                }
            }
        };

        thread1.start();
        thread2.start();
    }
}

/**
 * 输出结果(Vector在循环中删除元素是极其不安全的)：
 * <p>
 * Exception in thread "Thread-0" java.lang.ArrayIndexOutOfBoundsException: Array index out of range: 5
 * 	at java.util.Vector.remove(Vector.java:831)
 * 	at com.huawei.l00379880.mythread.Chapter05Immutable.Section6And7SynchronizedCollections.VectorUnsafeExample$1.run(VectorUnsafeExample.java:23)
 * Exception in thread "Thread-1" java.lang.ArrayIndexOutOfBoundsException: Array index out of range: 5
 * 	at java.util.Vector.get(Vector.java:748)
 * 	at com.huawei.l00379880.mythread.Chapter05Immutable.Section6And7SynchronizedCollections.VectorUnsafeExample$2.run(VectorUnsafeExample.java:32)
 * 	...
 */
