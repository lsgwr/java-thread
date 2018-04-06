/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/3/19 下午11:45
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync.firsthalf;

public class P60Run {
    public static void main(String[] args) {
        P59MyObject object = new P59MyObject();
        P59ThreadA a = new P59ThreadA(object);
        a.setName("A");
        P60ThreadB b = new P60ThreadB(object);
        b.setName("B");
        a.start();
        b.start();
    }
}
