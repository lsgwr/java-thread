/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/3/18 下午7:03
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter1basic;

public class P17Run {
    public static void main(String[] args) {
        P17CountOperate operate = new P17CountOperate();
        Thread t = new Thread(operate);
        t.setName("thread-0");
        t.start();
    }
}
