/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 下午9:29
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3com;

public class P181ThreadB extends Thread {
    @Override
    public void run() {
        try {
            P181ThreadA a = new P181ThreadA();
            a.start();
            a.join();
            System.out.println("线程B在run end处打印啦！");
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("线程B在catch处打印啦！");
        }
    }
}
