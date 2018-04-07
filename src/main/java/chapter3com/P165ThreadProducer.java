/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 下午6:21
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3com;

public class P165ThreadProducer extends Thread {
    private P165Producer producer;

    public P165ThreadProducer(P165Producer producer) {
        this.producer = producer;
    }

    @Override
    public void run() {
        while (true){
            producer.pushService();
        }
    }
}
