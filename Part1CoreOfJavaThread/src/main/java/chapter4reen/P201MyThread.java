/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 下午10:58
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter4reen;

public class P201MyThread extends Thread {
    P201MyService service;

    public P201MyThread(P201MyService service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.testMethod();
    }
}

