/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 下午9:54
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3com;

public class P188Run {
    public static void main(String[] args) throws InterruptedException {
        P188ThreadB threadB = new P188ThreadB();
        P187ThreadA threadA = new P187ThreadA(threadB);
        threadA.start();
        threadB.start();
        threadB.join(2000);
        System.out.println("                    main end " + System.currentTimeMillis());
    }
}
