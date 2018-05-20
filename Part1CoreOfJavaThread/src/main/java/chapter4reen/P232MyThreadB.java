/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/10 上午12:13
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter4reen;

public class P232MyThreadB extends Thread {
    private P232Service service;

    public P232MyThreadB(P232Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.notifyMethod();
    }
}

