/***********************************************************
 * @Description : 当一个线程访问Object的一个同步代码块的时候，其他线程
 *                对同一个Object钟的其他同步代码块访问将被阻塞
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/3/27 下午11:24
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync.firsthalf;

public class P78ThreadB extends Thread {
    private P78ObjectService service;

    public P78ThreadB(P78ObjectService service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.serviceMethodB();
    }
}
