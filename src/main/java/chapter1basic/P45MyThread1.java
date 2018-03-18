/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/3/18 下午9:54
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter1basic;

import java.util.Random;

public class P45MyThread1 extends Thread {
    @Override
    public void run() {
        long beginTime = System.currentTimeMillis();
        long addResult = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 50000; j++) {
                Random random = new Random();
                random.nextInt();
                addResult = addResult + j;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("★ ★ ★ ★ ★ thread1 use time = " + (endTime - beginTime));
    }
}
