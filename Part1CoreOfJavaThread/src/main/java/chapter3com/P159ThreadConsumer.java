/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 下午5:09
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3com;

public class P159ThreadConsumer extends Thread {
    private P159Consumer consumer;

    public P159ThreadConsumer(P159Consumer consumer) {
        this.consumer = consumer;
    }

    @Override
    public void run() {
        while (true) {
            consumer.getValue();
        }
    }
}
