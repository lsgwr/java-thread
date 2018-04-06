/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/6 下午8:27
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync.secondhalf;

public class P118Run {
    public static void main(String[] args) throws InterruptedException {
        P117Service service = new P117Service();
        P117UserInfo userInfo = new P117UserInfo();
        P118ThreadA threadA = new P118ThreadA(service, userInfo);
        threadA.setName("a");
        threadA.start();
        Thread.sleep(50);
        P118ThreadB threadB = new P118ThreadB(service, userInfo);
        threadB.setName("b");
        threadB.start();
    }
}
