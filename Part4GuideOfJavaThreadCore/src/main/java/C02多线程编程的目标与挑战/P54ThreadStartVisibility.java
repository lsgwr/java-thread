/***********************************************************
 * @Description : 线程的启动、停止与可见性
 * @author      : 梁山广(Liang Shan Guang)
 * @date        : 2020/3/7 16:04
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package C02多线程编程的目标与挑战;

import util.Tools;

public class P54ThreadStartVisibility {
    // 线程间的共享变量
    static int data = 0;

    public static void main(String[] args) {
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

        // 使当前线程休眠R毫秒(R的值为随机数)
        Tools.randomPause(50);

        // 在子线程thread启动后更新变量data的值
        data = 2;
    }
}
/**
 * 输出可能为1或2
 */
