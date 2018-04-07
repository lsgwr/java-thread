/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 下午10:17
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3com;

public class P192ThreadB extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 100; i++) {
                P192Tools.t1.set("ThreadB " + (i + 1));
                System.out.println("ThreadB get Value = "+P192Tools.t1.get());
                Thread.sleep(200);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
