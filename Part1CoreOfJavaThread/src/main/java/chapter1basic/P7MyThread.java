/***********************************************************
 * @Description : 验证start()方法的顺序不代表线程启动的顺序
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/3/18 下午1:46
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter1basic;

public class P7MyThread extends Thread {
    private int i;

    public P7MyThread(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println(i);
    }
}
