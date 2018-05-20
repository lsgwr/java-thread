/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/8 下午10:12
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter4reen;

public class P206MyThreadA extends Thread {
    private P206MyService myService;

    public P206MyThreadA(P206MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.waitMethod();
    }
}

