package com.xdclass.jvm;

/**
 * 指令重排序 demo
 */
public class Demo2 {

    static int x = 0, y = 0, a = 0, b = 0;

    public static void main(String[] args) throws InterruptedException {

        int i = 0;
        boolean flag = true;

        while (flag) {
            i++;
            Thread thread = new Thread(() -> {
                a = 1;
                x = b;
            });

            Thread thread1 = new Thread(() -> {
                b = 1;
                y = a;
            });

            thread.start();
            thread1.start();
            thread.join();
            thread1.join();

            System.out.println("第" + i + "次" + "x=======>" + x + "    y=========>" + y);

            if (x == 0 && y == 0) {
                flag = false;
            } else {
                x = 0;
                y = 0;
                a = 0;
                b = 0;
            }
        }


    }

}
