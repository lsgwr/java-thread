/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 下午6:55
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3com;

public class P170Run {
    public static void main(String[] args) {
        P168MyStack myStack = new P168MyStack();
        P168Producer producer1 = new P168Producer(myStack);
        P168Producer producer2 = new P168Producer(myStack);
        P168Producer producer3 = new P168Producer(myStack);
        P168Producer producer4 = new P168Producer(myStack);
        P168Producer producer5 = new P168Producer(myStack);
        P168Consumer consumer1 = new P168Consumer(myStack);
        P168Consumer consumer2 = new P168Consumer(myStack);
        P168Consumer consumer3 = new P168Consumer(myStack);
        P168Consumer consumer4 = new P168Consumer(myStack);
        P168Consumer consumer5 = new P168Consumer(myStack);
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
        P168ThreadConsumer threadConsumer1 = new P168ThreadConsumer(consumer1);
        P168ThreadConsumer threadConsumer2 = new P168ThreadConsumer(consumer2);
        P168ThreadConsumer threadConsumer3 = new P168ThreadConsumer(consumer3);
        P168ThreadConsumer threadConsumer4 = new P168ThreadConsumer(consumer4);
        P168ThreadConsumer threadConsumer5 = new P168ThreadConsumer(consumer5);
        threadConsumer1.start();
        threadConsumer2.start();
        threadConsumer3.start();
        threadConsumer4.start();
        threadConsumer5.start();
    }
}
