/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/3/19 下午11:14
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync;

public class P60ThreadB extends Thread {
    private P59MyObject object;

    public P60ThreadB(P59MyObject object) {
        this.object = object;
    }

    @Override
    public void run() {
        object.methodA();
    }
}
