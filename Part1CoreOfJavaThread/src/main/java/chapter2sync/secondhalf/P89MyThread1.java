/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/6 下午12:56
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync.secondhalf;

public class P89MyThread1 extends Thread {
    private P88MyOneList list;

    public P89MyThread1(P88MyOneList list) {
        this.list = list;
    }

    @Override
    public void run() {
        P89Service service = new P89Service();
        service.addServiceMethod(list, "A");
    }
}
