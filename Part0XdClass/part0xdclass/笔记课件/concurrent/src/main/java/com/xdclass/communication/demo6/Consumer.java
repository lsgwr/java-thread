package com.xdclass.communication.demo6;

/**
 * 消费者
 */
public class Consumer implements Runnable{

    private Medium medium;

    public Consumer( Medium medium) {
        this.medium = medium;
    }

    @Override
    public void run() {
        while (true) {
            medium.take();
        }
    }
}
