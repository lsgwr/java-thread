/***********************************************************
 * @Description : 线程终止与可见性
 * @author      : 梁山广(Liang Shan Guang)
 * @date        : 2020/3/7 16:56
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package C02多线程编程的目标与挑战;

import util.Tools;

public class P55ThreadJoinVisibility {
    // 线程间的共享变量
    static int data = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread() {
            @Override
            public void run() {
                // 使当前线程休眠R毫秒(R的值为随机数)
                Tools.randomPause(50);
                // 读取并打印data的值
                System.out.println(data);
            }
        };

        // 在子线程thread启动前更新data的值
        data = 1;
        thread.start();

        // 等待线程thread结束后，main线程才能继续运行
        thread.join();

        // 在子线程thread启动后更新变量data的值，输出一定是1
        data = 2;
    }
}
/**
 * 因为用了join所以输出一定为1
 */
