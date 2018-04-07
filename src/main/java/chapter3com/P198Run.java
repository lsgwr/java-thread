/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 下午10:36
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3com;

public class P198Run {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            System.out.println("     在Main中取值 = " + P197Tools.t1.get());
            Thread.sleep(100);
        }
        Thread.sleep(5000);
        P197ThreadA threadA = new P197ThreadA();
        threadA.start();
    }
}
