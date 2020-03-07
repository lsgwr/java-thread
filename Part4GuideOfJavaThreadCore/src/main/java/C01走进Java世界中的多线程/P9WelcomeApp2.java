/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/5/21 22:18
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package C01走进Java世界中的多线程;


public class P9WelcomeApp2 {
    public static void main(String[] args) {
        // 创建线程
        Thread welcomeThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("2.Welcome! I'm " + Thread.currentThread().getName());
            }
        });
        // 启动线程
        welcomeThread.start();
        // 只是运行run方法，不是多线程的正确用法
        welcomeThread.run();
        System.out.println("1.Welcome! I'm " + Thread.currentThread().getName());
    }
}
/**
 * 2.Welcome! I'm main
 * 2.Welcome! I'm Thread-0
 * 1.Welcome! I'm main
 */
