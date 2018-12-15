package com.xdclass.thread.guard;

/**
 * 守护线程Demo
 */
public class DaemonThreadDemo implements Runnable{
    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new DaemonThreadDemo());
        thread.start();
        thread.setDaemon(true);
        Thread.sleep(2000L);
    }
}
