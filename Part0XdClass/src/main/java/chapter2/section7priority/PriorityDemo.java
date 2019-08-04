/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018-12-15 20:35
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2.section7priority;

public class PriorityDemo {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ", Thread优先级=" + Thread.currentThread().getPriority());
            }
        }, "线程1");
        Thread thread2 = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ", Thread优先级=" + Thread.currentThread().getPriority());
            }
        }, "线程2");
        // 数字越大优先级越高，尽量少靠优先级来决定执行顺序，因为优先级只是"可能"会早处理罢了
        thread1.setPriority(Thread.MIN_PRIORITY);
        thread2.setPriority(Thread.MAX_PRIORITY);
        thread1.start();
        thread2.start();
    }

}
