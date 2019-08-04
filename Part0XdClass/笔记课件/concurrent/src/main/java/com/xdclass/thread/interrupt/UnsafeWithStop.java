package com.xdclass.thread.interrupt;

public class UnsafeWithStop extends Thread {

    private int i = 0;
    private int j = 0;

    @Override
    public void run() {
        i++;
        try {
            sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        j++;
    }

    public void printf() {
        System.out.println("i的值=======》"+i);
        System.out.println("j的值=======》"+j);
    }


    public static void main(String[] args) throws InterruptedException {
        UnsafeWithStop unsafeWithStop = new UnsafeWithStop();
        unsafeWithStop.start();
        Thread.sleep(1000L);
        unsafeWithStop.stop();
        unsafeWithStop.printf();
    }
}
