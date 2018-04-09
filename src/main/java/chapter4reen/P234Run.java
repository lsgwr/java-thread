/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/10 上午12:15
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter4reen;

public class P234Run {
    public static void main(String[] args) throws InterruptedException {
        P232Service service = new P232Service();
        P232MyThreadA threadA = new P232MyThreadA(service);
        threadA.start();
        Thread.sleep(2000);
        P232MyThreadB threadB = new P232MyThreadB(service);
        threadB.start();
    }
}
