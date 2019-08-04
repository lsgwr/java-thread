package com.xdclass.communication.demo5;

/**
 * ThreadLocalDemo
 */
public class ThreadLocalDemo {
    ThreadLocal<Integer> num = ThreadLocal.withInitial(() -> 0);

    /**
     * 自增并输出num的值
     */
    public void inCreate() {
        Integer myNum = num.get();
        myNum++;
        System.out.println(Thread.currentThread().getName() + "----------->" + myNum);
        num.set(myNum);
    }

    public static void main(String[] args) {
        ThreadLocalDemo threadLocalDemo = new ThreadLocalDemo();
        for (int i = 1; i < 3; i++) {
            int finalI = i;
            new Thread(() -> {
                while (true) {
                    threadLocalDemo.inCreate();
                    try {
                        Thread.sleep(finalI * 1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
