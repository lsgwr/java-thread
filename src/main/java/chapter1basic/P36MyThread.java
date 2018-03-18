/***********************************************************
 * @Description : 利用interrupt()与return结合实现线程退出
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/3/18 下午8:21
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter1basic;

public class P36MyThread extends Thread {
    @Override
    public void run() {
        while (true) {
            if (this.isInterrupted()) {
                System.out.println("线程停止了！");
                return;
            }
            // 打印下时间
            System.out.println("timer = " + System.currentTimeMillis());
        }
    }
}
