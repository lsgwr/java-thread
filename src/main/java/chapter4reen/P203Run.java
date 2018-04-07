/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 下午11:47
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter4reen;

public class P203Run {
    public static void main(String[] args) throws InterruptedException {
        P202MyService service = new P202MyService();
        P203ThreadA a = new P203ThreadA(service);
        a.setName("A");
        a.start();
        P203ThreadA aa = new P203ThreadA(service);
        aa.setName("AA");
        aa.start();
        Thread.sleep(100);
        P203ThreadB b = new P203ThreadB(service);
        b.setName("B");
        b.start();
        P203ThreadBB bb = new P203ThreadBB(service);
        bb.setName("BB");
        bb.start();
    }
}
