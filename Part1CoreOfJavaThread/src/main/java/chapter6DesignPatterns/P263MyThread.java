/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/11 下午10:52
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter6DesignPatterns;

public class P263MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(P262MyObject.getInstance().hashCode());
    }
}
