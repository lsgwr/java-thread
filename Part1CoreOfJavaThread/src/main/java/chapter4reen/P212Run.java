/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/9 上午12:09
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter4reen;

public class P212Run {
    public static void main(String[] args) throws InterruptedException {
        P211MyService service = new P211MyService();
        P212ThreadA threadA = new P212ThreadA(service);
        threadA.setName("A");
        threadA.start();
        P212ThreadB threadB = new P212ThreadB(service);
        threadB.setName("B");
        threadB.start();
        Thread.sleep(3000);
        service.signalAll_A();
    }
}
