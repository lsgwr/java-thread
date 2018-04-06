/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/6 下午2:08
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync.secondhalf;

public class P94ThreadB extends Thread {
    private P93MyObject object;

    public P94ThreadB(P93MyObject object) {
        this.object = object;
    }

    @Override
    public void run() {
        object.speedPrintString();
    }
}
