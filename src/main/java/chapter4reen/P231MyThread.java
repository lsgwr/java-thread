/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/9 下午11:57
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter4reen;

public class P231MyThread extends Thread {
    private P230Service service;

    public P231MyThread(P230Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.testMethod();
    }
}
