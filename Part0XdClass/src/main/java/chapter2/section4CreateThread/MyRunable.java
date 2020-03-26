/***********************************************************
 * @Description : 方法1：实现Runnable接口
 * @author      : 梁山广(Liang Shan Guang)
 * @date        : 2020/3/27 0:39
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2.section4CreateThread;

import java.io.IOException;
import java.io.Serializable;

public class MyRunable implements Runnable, Serializable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunable());
        thread.setName("xdclass");
//        thread.start();
        thread.run();
    }
}
