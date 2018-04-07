/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 下午5:09
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3com;

public class P159ThreadProducer extends Thread {
    private P158Producer producer;

    public P159ThreadProducer(P158Producer producer) {
        this.producer = producer;
    }

    @Override
    public void run() {
        while (true) {
            producer.setValue();
        }
    }
}
