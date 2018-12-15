package com.xdclass.container.demo;

import java.util.Iterator;
import java.util.Vector;

public class VectorDemo {

    public static void main(String[] args) {
        Vector<String> stringVector = new Vector<>();
        for (int i = 0; i < 1000; i++) {
            stringVector.add("demo" + i);
        }

        //错误遍历
//        stringVector.forEach(e->{
//            if (e.equals("demo3")) {
//                stringVector.remove(e);
//            }
//            System.out.println(e);
//        });

        //正确迭代
        Iterator<String> stringIterator = stringVector.iterator();
//        while (stringIterator.hasNext()) {
//            String next = stringIterator.next();
//            if (next.equals("demo2")) {
//                stringIterator.remove();
//            }
//        }

        for (int i = 0; i < 4; i++) {
            new Thread(() -> {
                synchronized (stringIterator) {
                    while (stringIterator.hasNext()) {
                        String next = stringIterator.next();
                        if (next.equals("demo2")) {
                            stringIterator.remove();
                        }
                    }
                }
            }).start();
        }
    }

}
