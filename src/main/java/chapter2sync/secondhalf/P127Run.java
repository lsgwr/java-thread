/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/6 下午10:29
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync.secondhalf;

public class P127Run {
    public static void main(String[] args) {
        P127AddCountThread countThread = new P127AddCountThread();
        Thread t1 = new Thread(countThread);
        t1.start();
        Thread t2 = new Thread(countThread);
        t2.start();
        Thread t3 = new Thread(countThread);
        t3.start();
        Thread t4 = new Thread(countThread);
        t4.start();
        Thread t5 = new Thread(countThread);
        t5.start();
    }
}
