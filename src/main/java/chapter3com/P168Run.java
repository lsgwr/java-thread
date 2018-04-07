/***********************************************************
 * @Description : 因为list的size没有被及时更新(原因是啥待细究)，
 *                会出现多个pop线程被唤醒，进而remove(0)的时候出现异常
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 下午6:34
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3com;

public class P168Run {
    public static void main(String[] args) throws InterruptedException {
        P168MyStack myStack = new P168MyStack();
        P168Producer producer = new P168Producer(myStack);
        P168Consumer consumer1 = new P168Consumer(myStack);
        P168Consumer consumer2 = new P168Consumer(myStack);
        P168Consumer consumer3 = new P168Consumer(myStack);
        P168ThreadProducer threadProducer = new P168ThreadProducer(producer);
        threadProducer.start();
        P168ThreadConsumer threadConsumer1 = new P168ThreadConsumer(consumer1);
        P168ThreadConsumer threadConsumer2 = new P168ThreadConsumer(consumer2);
        P168ThreadConsumer threadConsumer3 = new P168ThreadConsumer(consumer3);
        threadConsumer1.start();
        threadConsumer2.start();
        threadConsumer3.start();
    }
}
