/***********************************************************
 * @Description : 方法4：lambda表达式创建线程
 * @author      : 梁山广(Liang Shan Guang)
 * @date        : 2020/3/27 0:42
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2.section4CreateThread;

public class LambdaThread {
    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        }).start();
    }
}
