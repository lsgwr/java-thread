/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 下午9:29
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3com;

public class P182ThreadC extends Thread {
    private P181ThreadB threadB;

    public P182ThreadC(P181ThreadB threadB) {
        this.threadB = threadB;
    }

    @Override
    public void run() {
        threadB.interrupt();
    }
}
