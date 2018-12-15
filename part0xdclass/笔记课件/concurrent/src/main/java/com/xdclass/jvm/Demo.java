package com.xdclass.jvm;

public class Demo {

    private volatile int  value = 0;

    //b后调用
    public synchronized int getValue() {
        return value;
    }

    //a先调用
    public synchronized void setValue(int value) {
        this.value = value;
    }

    public static void main(String[] args) {
        int i = 0;
        int j = 1;
    }
}
