/***********************************************************
 * @Description : 多个线程可以同时获取读锁
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/10 下午10:35
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter4reen;

public class P237Run {
    public static void main(String[] args) {
        P236Service service = new P236Service();
        P237ThreadA threadA = new P237ThreadA(service);
        threadA.setName("A");
        P237ThreadB threadB = new P237ThreadB(service);
        threadB.setName("B");
        threadA.start();
        threadB.start();
    }
}
