/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 下午9:54
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3com;

public class P186Run {
    public static void main(String[] args) throws InterruptedException {
        P185ThreadB threadB = new P185ThreadB();
        P185ThreadA threadA = new P185ThreadA(threadB);
        threadA.start();
        Thread.sleep(1000);
        P186ThreadC threadC = new P186ThreadC(threadB);
        threadC.start();
    }
}
