/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/3/18 下午5:44
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter1basic;

public class P11MyThread extends Thread {
    private int count = 5;

    public P11MyThread() {
        this.count = count;
    }

    /**
     * 去掉synchronized会出现线程变量访问不一致的情况。synchronized public void run()
     */
    @Override
    synchronized public void run() {
        count--;
        System.out.println("由 " + currentThread().getName() + " 计算，count = " + count);
    }
}
