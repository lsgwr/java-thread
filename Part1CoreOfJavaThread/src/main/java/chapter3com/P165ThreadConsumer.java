/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 下午6:21
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3com;

public class P165ThreadConsumer extends Thread {
    private P165Consumer consumer;

    public P165ThreadConsumer(P165Consumer consumer) {
        this.consumer = consumer;
    }

    @Override
    public void run() {
        while (true) {
            consumer.popService();
        }
    }
}
