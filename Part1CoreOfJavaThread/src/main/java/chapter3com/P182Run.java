/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 下午9:33
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3com;

public class P182Run {
    public static void main(String[] args) throws InterruptedException {
        P181ThreadB threadB = new P181ThreadB();
        threadB.start();
        Thread.sleep(500);
        P182ThreadC threadC = new P182ThreadC(threadB);
        threadC.start();
    }
}
