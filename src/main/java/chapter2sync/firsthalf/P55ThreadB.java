/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/3/19 上午12:19
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync.firsthalf;

public class P55ThreadB extends Thread {
    private P55HasSelfPrivateNum numRef;

    public P55ThreadB(P55HasSelfPrivateNum numRef) {
        this.numRef = numRef;
    }

    @Override
    public void run() {
        try {
            numRef.addI("b");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
