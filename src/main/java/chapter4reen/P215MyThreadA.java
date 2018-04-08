/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/9 上午12:22
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter4reen;

public class P215MyThreadA extends Thread {
    private P215MyService myService;

    public P215MyThreadA(P215MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            myService.set();
        }
    }
}
