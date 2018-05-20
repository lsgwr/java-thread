/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/3/19 上午12:21
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync.firsthalf;

public class P56Run {
    public static void main(String[] args) {
        P55HasSelfPrivateNum numRef = new P55HasSelfPrivateNum();
        P55ThreadA a = new P55ThreadA(numRef);
        a.start();
        P55ThreadB b = new P55ThreadB(numRef);
        b.start();
    }
}
