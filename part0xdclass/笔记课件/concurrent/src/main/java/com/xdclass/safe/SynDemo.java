package com.xdclass.safe;

/**
 * 深入理解synchronized关键字
 */
public class  SynDemo {

//    public synchronized void out() throws InterruptedException {
//        System.out.println(Thread.currentThread().getName());
//        Thread.sleep(5000L);
//    }

    //    public static synchronized void staticOut() throws InterruptedException {
//        System.out.println(Thread.currentThread().getName());
//        Thread.sleep(5000L);
//    }
//
    private Object lock = new Object();

    public void myOut() {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SynDemo synDemo = new SynDemo();


        new Thread(() -> {
                synDemo.myOut();
        }).start();

        new Thread(() -> {
             synDemo.myOut();
        }).start();

    }
}
