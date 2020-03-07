/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/5/21 22:18
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package C01走进Java世界中的多线程;

class WelcomeTask implements Runnable {

    @Override
    public void run() {
        System.out.println("2.Welcome! I'm " + Thread.currentThread().getName());
    }
}

public class P7WelcomeApp1 {
    public static void main(String[] args) {
        // 创建线程
        Thread welcomeThread = new Thread(new WelcomeTask());
        // 启动线程
        welcomeThread.start();
        System.out.println("1.Welcome! I'm " + Thread.currentThread().getName());
    }
}
/**
 * 1.Welcome! I'm main
 * 2.Welcome! I'm Thread-0
 */
