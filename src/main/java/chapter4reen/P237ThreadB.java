/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/10 下午10:36
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter4reen;

public class P237ThreadB extends Thread {
    private P236Service service;

    public P237ThreadB(P236Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.read();
    }
}
