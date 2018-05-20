/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/3/19 上午12:21
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync.firsthalf;

public class P54Run {
    public static void main(String[] args) {
        P53HasSelfPrivateNum numRef = new P53HasSelfPrivateNum();
        P53ThreadA a = new P53ThreadA(numRef);
        a.start();
        P54ThreadB b = new P54ThreadB(numRef);
        b.start();
    }
}
