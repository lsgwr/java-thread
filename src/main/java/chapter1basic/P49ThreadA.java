/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/3/18 下午11:48
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter1basic;

public class P49ThreadA extends Thread {
    private int count = 0;

    public int getCount() {
        return count;
    }

    @Override
    public void run() {
        while (true) {
            count++;
        }
    }
}
