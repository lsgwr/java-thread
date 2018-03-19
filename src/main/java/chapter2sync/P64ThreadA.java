/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/3/20 上午12:14
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync;

public class P64ThreadA extends Thread {
    private P63PublicVar publicVar;

    public P64ThreadA(P63PublicVar publicVar) {
        this.publicVar = publicVar;
    }

    @Override
    public void run() {
        publicVar.setValue("B", "BB");
    }
}
