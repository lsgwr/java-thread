/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/6 下午7:58
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync.secondhalf;

public class P116Run {
    public static void main(String[] args) throws InterruptedException {
        P115MyService service = new P115MyService();
        P116ThreadA threadA = new P116ThreadA(service);
        threadA.setName("A");
        P116ThreadB threadB = new P116ThreadB(service);
        threadB.setName("B");
        threadA.start();
        // 延时50ms后线程B取得的锁是"456",所以A和B是异步执行，去掉后来不及修改，A和B都是抢"123"的锁，会变成顺序执行
        Thread.sleep(50);
        threadB.start();
    }
}
