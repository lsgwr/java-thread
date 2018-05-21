/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/5/21 22:18
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package Chapter01WalkingIntoJavaThread;

class WelcomeThread extends Thread {

    @Override
    public void run() {
        System.out.println("2.Welcome! I'm " + Thread.currentThread().getName());
    }
}

public class P6WelcomeApp {
    public static void main(String[] args) {
        // 创建线程
        Thread welcomeThread = new WelcomeThread();
        // 启动线程
        welcomeThread.start();
        System.out.println("1.Welcome! I'm " + Thread.currentThread().getName());
    }
}
