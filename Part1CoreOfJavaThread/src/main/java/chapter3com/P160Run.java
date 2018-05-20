/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 下午5:17
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3com;

public class P160Run {
    public static void main(String[] args) {
        String lock = new String("");
        P158Producer producer = new P158Producer(lock);
        P159Consumer consumer = new P159Consumer(lock);
        P159ThreadProducer threadProducer = new P159ThreadProducer(producer);
        P159ThreadConsumer threadConsumer = new P159ThreadConsumer(consumer);
        threadProducer.start();
        threadConsumer.start();
    }

}
