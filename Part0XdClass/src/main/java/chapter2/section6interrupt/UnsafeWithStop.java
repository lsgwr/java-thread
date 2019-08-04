/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018-12-15 19:29
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2.section6interrupt;

public class UnsafeWithStop extends Thread {
    private int i = 0;
    private int j = 0;

    @Override
    public void run() {
        i++;
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        j++;
    }

    private void print() {
        System.out.println("i = " + i);
        System.out.println("j = " + j);
    }

    public static void main(String[] args) throws InterruptedException {
        UnsafeWithStop unsafeWithStop = new UnsafeWithStop();
        unsafeWithStop.start();
        Thread.sleep(1000L);
        // stop() 废弃方法，开发中不要使用。因为一调用，线程就立刻停止，此时有可能引发相应的线程安全性问题
        unsafeWithStop.stop();
        unsafeWithStop.print();
    }
}
