/***********************************************************
 * @Description : synchronized取得的都是对象锁，当多个对象时，就有
 *                多个锁，所以最后的结果会交叉打印
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/3/19 上午12:21
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync;

public class P58Run {
    public static void main(String[] args) {
        P55HasSelfPrivateNum numRef1 = new P55HasSelfPrivateNum();
        P55HasSelfPrivateNum numRef2 = new P55HasSelfPrivateNum();
        P55ThreadA a = new P55ThreadA(numRef1);
        a.start();
        P55ThreadB b = new P55ThreadB(numRef2);
        b.start();
    }
}
