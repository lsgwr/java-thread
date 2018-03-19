/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/3/19 下午11:45
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync;

public class P62Run {
    public static void main(String[] args) {
        P61MyObject object = new P61MyObject();
        P62ThreadA a = new P62ThreadA(object);
        a.setName("A");
        P62ThreadB b = new P62ThreadB(object);
        b.setName("B");
        a.start();
        b.start();
    }
}
