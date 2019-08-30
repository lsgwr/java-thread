package com.huawei.l00379880.mythread.Chapter05Immutable.Section6And7SynchronizedCollections;

import java.util.Vector;

public class VectorExample3 {

    private static void test1(Vector<Integer> v1) {
        // 在遍历的同时进行了删除的操作，会抛出java.util.ConcurrentModificationException并发修改异常
        for (Integer integer : v1) {
            if (integer.equals(5)) {
                v1.remove(integer);
            }
        }
    }

    private static void test2(Vector<Integer> v1) {
        // 在遍历的同时进行了删除的操作，会抛出java.util.ConcurrentModificationException并发修改异常
        Iterator<Integer> iterator = v1.iterator();
        while (iterator.hasNext()) {
            Integer integer = iterator.next();
            if (integer.equals(5)) {
                v1.remove(integer);
            }
        }
    }

    private static void test3(Vector<Integer> v1) {
        // 可以正常删除
        for (int i = 0; i < v1.size(); i++) {
            if (v1.get(i).equals(5)) {
                v1.remove(i);
            }
        }
    }

    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<>();
        for (int i = 1; i <= 5; i++) {
            vector.add(i);
        }
        test1(vector);
//        test2(vector);
//        test3(vector);
    }
}
