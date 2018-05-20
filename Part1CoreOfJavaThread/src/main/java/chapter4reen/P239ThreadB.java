/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/10 下午10:36
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter4reen;

public class P239ThreadB extends Thread {
    private P239Service service;

    public P239ThreadB(P239Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.write();
    }
}
