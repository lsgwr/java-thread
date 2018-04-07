/***********************************************************
 * @Description : join后面的代码提前运行
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 下午9:49
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3com;

public class P188ThreadB extends Thread {

    @Override
    synchronized public void run() {
        try {
            System.out.println("begin B threadName = " + Thread.currentThread().getName() + "  " + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("  end B threadName = " + Thread.currentThread().getName() + "  " + System.currentTimeMillis());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
