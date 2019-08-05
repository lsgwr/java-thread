package chapter7container.section1sync;

import java.util.Iterator;
import java.util.Vector;

public class VectorDemo {

    public static void main(String[] args) {
        Vector<String> stringVector = new Vector<>();
        for (int i = 0; i < 1000; i++) {
            stringVector.add("section1sync" + i);
        }

        //错误遍历,不能再for循环中修改集合对象
//        stringVector.forEach(e->{
//            if (e.equals("demo3")) {
//                stringVector.remove(e);
//            }
//            System.out.println(e);
//        });

        //正确迭代，可以用迭代器在迭代过程中修改集合
        Iterator<String> stringIterator = stringVector.iterator();
//        while (stringIterator.hasNext()) {
//            String next = stringIterator.next();
//            if (next.equals("demo2")) {
//                stringIterator.remove();
//            }
//        }

        for (int i = 0; i < 4; i++) {
            new Thread(() -> {
                // 多线程修改集合，修改操作必须同步
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
