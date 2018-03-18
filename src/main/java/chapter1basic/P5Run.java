/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/3/18 下午1:16
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter1basic;

public class P5Run {
    public static void main(String[] args) {
        P5MyThread thread = new P5MyThread();
        thread.start();
        System.out.println("运行结束！！");
    }
}
