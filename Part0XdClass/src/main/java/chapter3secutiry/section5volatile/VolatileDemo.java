/***********************************************************
 * @Description : volatile关键字及其使用场景
 *     	能且仅能修饰变量
 *     	保证该变量的可见性，volatile关键字仅仅保证可见性，并不保证原子性
 *     	禁止指令重排序
 *
 *     	A、B两个线程同时读取volatile关键字修饰的对象
 *     	A读取之后，修改了变量的值
 *     	修改后的值，对B线程来说，是可见
 *
 *     	使用场景
 *     		1：作为线程开关
 *     		2：单例，修饰对象实例，禁止指令重排序
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018-12-16 19:38
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3secutiry.section5volatile;

public class VolatileDemo implements Runnable {
    private static volatile boolean FLAG = true;

    @Override
    public void run() {
        while (FLAG) {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
