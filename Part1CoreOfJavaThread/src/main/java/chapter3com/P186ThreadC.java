/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 下午9:49
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3com;

public class P186ThreadC extends Thread {
    private P185ThreadB threadB;

    public P186ThreadC(P185ThreadB threadB) {
        this.threadB = threadB;
    }

    @Override
    public void run() {
       threadB.bService();
    }

}
