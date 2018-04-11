/***********************************************************
 * @Description : NULL检查+锁的机制。P268~P271都是探讨懒汉模式的优缺点，
 *                以及改进。这个文件里的实现是最优地
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/11 下午11:15
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter6DesignPatterns;

public class P267Run {
    public static void main(String[] args) {
        P266MyThread myThread1 = new P266MyThread();
        P266MyThread myThread2 = new P266MyThread();
        P266MyThread myThread3 = new P266MyThread();
        myThread1.start();
        myThread2.start();
        myThread3.start();
    }
}
