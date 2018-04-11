/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/12 上午12:25
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter6DesignPatterns;

public class P272MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(P272MyObject.getInstance().hashCode());
    }
}
