/***********************************************************
 * @Description : P8MyRunnable的测试类
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/3/18 下午1:53
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter1basic;

public class P8Run {
    public static void main(String[] args) {
        Runnable runnable = new P8MyRunnable();
        Thread thread = new Thread(runnable);
        thread.start();
        System.out.println("运行结束！");
    }
}
