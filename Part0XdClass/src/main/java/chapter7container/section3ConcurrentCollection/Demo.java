package chapter7container.section3ConcurrentCollection;

import java.util.concurrent.CopyOnWriteArrayList;

public class Demo {

    public static void main(String[] args) {
        // 直接用支持并发的集合类型CopyOnWriteArrayList即可
        CopyOnWriteArrayList<String> strings = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 1000; i++) {
            strings.add("demo" + i);
        }
//        strings.forEach(e->{
//            if (e.equals("demo2")) {
//                strings.remove(e);
//            }
//        });
//        Iterator<String> iterator = strings.iterator();
//        while (iterator.hasNext()) {
//            String next = iterator.next();
//            if (next.equals("demo2")) {
//                iterator.remove();
//            }
//        }

        for (int i = 0; i < 4; i++) {
            new Thread(() -> {
                strings.forEach(e -> {
                    if (e.equals("demo2")) {
                        strings.remove(e);
                    }
                });
            }).start();
        }
    }

}
