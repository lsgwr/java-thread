/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/3/19 下午11:14
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync;

public class P62ThreadB extends Thread {
    private P61MyObject object;

    public P62ThreadB(P61MyObject object) {
        this.object = object;
    }

    @Override
    public void run() {
        object.methodB();
    }
}
