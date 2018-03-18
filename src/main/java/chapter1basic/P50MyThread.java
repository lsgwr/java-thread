/***********************************************************
 * @Description : 守护线程
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/3/18 下午11:56
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter1basic;

public class P50MyThread extends Thread {
    private int i = 0;

    @Override
    public void run() {
        try {
            while (true) {
                i++;
                System.out.println("i = " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
