/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/3/19 上午12:19
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync.firsthalf;

public class P53ThreadA extends Thread {
    private P53HasSelfPrivateNum numRef;

    public P53ThreadA(P53HasSelfPrivateNum numRef) {
        this.numRef = numRef;
    }

    @Override
    public void run() {
        try {
            numRef.addI("a");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
