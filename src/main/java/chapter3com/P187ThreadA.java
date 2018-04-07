/***********************************************************
 * @Description : join后面的代码提前运行
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 下午9:49
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3com;

public class P187ThreadA extends Thread {
    private P188ThreadB threadB;

    public P187ThreadA(P188ThreadB threadB) {
        this.threadB = threadB;
    }

    @Override
    public void run() {
        try {
            synchronized (threadB) {
                System.out.println("begin A threadName = " + Thread.currentThread().getName() + "  " + System.currentTimeMillis());
                Thread.sleep(5000);
                System.out.println("  end A threadName = " + Thread.currentThread().getName() + "  " + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
