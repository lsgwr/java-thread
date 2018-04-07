/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 下午5:09
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3com;

public class P162ThreadConsumer extends Thread {
    private P161Consumer consumer;

    public P162ThreadConsumer(P161Consumer consumer) {
        this.consumer = consumer;
    }

    @Override
    public void run() {
        while (true) {
            consumer.getValue();
        }
    }
}
