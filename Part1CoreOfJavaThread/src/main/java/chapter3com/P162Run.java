/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 下午5:32
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3com;

public class P162Run {
    public static void main(String[] args) throws InterruptedException {
        String lock = new String("");
        P161Producer producer = new P161Producer(lock);
        P161Consumer consumer = new P161Consumer(lock);
        P162ThreadProducer[] threadProducers = new P162ThreadProducer[2];
        P162ThreadConsumer[] threadConsumers = new P162ThreadConsumer[2];
        for (int i = 0; i < 2; i++) {
            threadProducers[i] = new P162ThreadProducer(producer);
            threadProducers[i].setName("生产者" + (i + 1));
            threadProducers[i].start();
            threadConsumers[i] = new P162ThreadConsumer(consumer);
            threadConsumers[i].setName("消费者" + (i + 1));
            threadConsumers[i].start();
        }
        Thread.sleep(5000);
        Thread[] threads = new Thread[Thread.currentThread().getThreadGroup().activeCount()];
        Thread.currentThread().getThreadGroup().enumerate(threads);
        for (Thread thread : threads) {
            System.out.println(thread.getName() + " " + thread.getState());
        }
    }
}
