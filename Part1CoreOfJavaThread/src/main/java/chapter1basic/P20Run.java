/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/3/18 下午7:19
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter1basic;

public class P20Run {
    public static void main(String[] args) {
        P19CountOperate operate = new P19CountOperate();
        Thread t = new Thread(operate);
        System.out.println("main begin. t1 isAlive?" + t.isAlive());
        t.setName("thread-0");
        t.start();
        System.out.println("main end.   t1 isAlive?" + t.isAlive() + "\n");
    }
}
