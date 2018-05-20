/***********************************************************
 * @Description : 异常法实现线程退出
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/3/18 下午8:10
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter1basic;

public class P29MyThread extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 500000; i++) {
                if (Thread.interrupted()) {
                    System.out.println("线程已经停止了！我要退出了！");
                    throw new InterruptedException();
                }
                System.out.println("i = " + (i + 1));
            }
            System.out.println("我在for的下面");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
