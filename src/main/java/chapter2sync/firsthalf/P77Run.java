/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/3/26 下午11:31
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync.firsthalf;

public class P77Run {
    public static void main(String[] args) {
        P77Task task = new P77Task();
        P77Thread1 thread1 = new P77Thread1(task);
        thread1.start();
        P77Thread2 thread2 = new P77Thread2(task);
        thread2.start();
    }
}
