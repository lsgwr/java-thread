/***********************************************************
 * @Description : 多生产者对一消费者
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 下午6:34
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3com;

public class P169Run {
    public static void main(String[] args) throws InterruptedException {
        P168MyStack myStack = new P168MyStack();
        P168Producer producer1 = new P168Producer(myStack);
        P168Producer producer2 = new P168Producer(myStack);
        P168Producer producer3 = new P168Producer(myStack);
        P168Producer producer4 = new P168Producer(myStack);
        P168Producer producer5 = new P168Producer(myStack);
        P168Consumer consumer = new P168Consumer(myStack);
        P168ThreadProducer threadProducer1 = new P168ThreadProducer(producer1);
        P168ThreadProducer threadProducer2 = new P168ThreadProducer(producer2);
        P168ThreadProducer threadProducer3 = new P168ThreadProducer(producer3);
        P168ThreadProducer threadProducer4 = new P168ThreadProducer(producer4);
        P168ThreadProducer threadProducer5 = new P168ThreadProducer(producer5);
        threadProducer1.start();
        threadProducer2.start();
        threadProducer3.start();
        threadProducer4.start();
        threadProducer5.start();
        P168ThreadConsumer threadConsumer = new P168ThreadConsumer(consumer);
        threadConsumer.start();
    }
}
