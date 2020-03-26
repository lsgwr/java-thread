/***********************************************************
 * @Description : 方法3：匿名内部类创建线程
 * @author      : 梁山广(Liang Shan Guang)
 * @date        : 2020/3/27 0:41
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2.section4CreateThread;

public class AnonymousThread {

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
        thread.start();
    }
}
