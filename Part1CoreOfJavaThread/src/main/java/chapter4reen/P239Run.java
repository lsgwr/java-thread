/***********************************************************
 * @Description : 多个线程可以同时获取读锁
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/10 下午10:35
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter4reen;

public class P239Run {
    public static void main(String[] args) {
        P239Service service = new P239Service();
        P239ThreadA threadA = new P239ThreadA(service);
        threadA.setName("A");
        P239ThreadB threadB = new P239ThreadB(service);
        threadB.setName("B");
        threadA.start();
        threadB.start();
    }
}
