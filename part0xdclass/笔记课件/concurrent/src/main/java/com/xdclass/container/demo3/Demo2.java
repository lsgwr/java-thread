package com.xdclass.container.demo3;

import java.util.concurrent.LinkedBlockingQueue;

public class Demo2 {
    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue<String> strings = new LinkedBlockingQueue<>();
        //往队列里存元素
        strings.add("111");
        strings.offer("111");
        strings.put("111");

        //从队列中取元素
        String remove = strings.remove();
        strings.poll();
        strings.take();

    }
}
