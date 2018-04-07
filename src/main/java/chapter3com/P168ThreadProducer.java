/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 下午6:21
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3com;

public class P168ThreadProducer extends Thread {
    private P168Producer producer;

    public P168ThreadProducer(P168Producer producer) {
        this.producer = producer;
    }

    @Override
    public void run() {
        while (true){
            producer.pushService();
        }
    }
}
