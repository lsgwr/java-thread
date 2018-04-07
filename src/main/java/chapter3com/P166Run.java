/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 下午6:27
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3com;

public class P166Run {
    public static void main(String[] args) throws InterruptedException {
        P164MyStack myStack = new P164MyStack();
        P165Producer producer = new P165Producer(myStack);
        P165Consumer consumer = new P165Consumer(myStack);
        P165ThreadProducer threadProducer = new P165ThreadProducer(producer);
        P165ThreadConsumer threadConsumer = new P165ThreadConsumer(consumer);
        threadProducer.start();
        Thread.sleep(100);
        threadConsumer.start();
    }
}
