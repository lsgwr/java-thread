/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/10 下午10:36
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter4reen;

public class P238ThreadB extends Thread {
    private P238Service service;

    public P238ThreadB(P238Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.write();
    }
}
