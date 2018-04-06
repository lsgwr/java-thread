/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/6 下午12:58
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync.secondhalf;

public class P90Run {
    public static void main(String[] args) throws InterruptedException {
        P88MyOneList list = new P88MyOneList();
        P89MyThread1 thread1 = new P89MyThread1(list);
        thread1.setName("A");
        thread1.start();
        P89MyThread2 thread2 = new P89MyThread2(list);
        thread2.setName("B");
        thread2.start();
        Thread.sleep(6000);
        System.out.println("listSize = " + list.getSize());
    }
}
