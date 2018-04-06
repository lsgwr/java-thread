/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/6 下午10:34
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync.secondhalf;

public class P128MyThread extends Thread {
    private P128MyService myService;

    public P128MyThread(P128MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.addNum();
    }
}
