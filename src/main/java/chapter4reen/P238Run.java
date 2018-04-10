/***********************************************************
 * @Description : 多个线程可以同时获取读锁
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/10 下午10:35
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter4reen;

public class P238Run {
    public static void main(String[] args) {
        P238Service service = new P238Service();
        P238ThreadA threadA = new P238ThreadA(service);
        threadA.setName("A");
        P238ThreadB threadB = new P238ThreadB(service);
        threadB.setName("B");
        threadA.start();
        threadB.start();
    }
}
