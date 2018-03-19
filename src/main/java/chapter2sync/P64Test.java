/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/3/20 上午12:17
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync;

public class P64Test {
    public static void main(String[] args) {
        try {
            P63PublicVar publicVar = new P63PublicVar();
            P64ThreadA threadA = new P64ThreadA(publicVar);
            threadA.start();
            Thread.sleep(200);
            publicVar.getValue();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
