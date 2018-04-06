/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/6 下午5:25
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync.secondhalf;

public class P99Run {
    public static void main(String[] args) {
        P97Service service = new P97Service();
        P98ThreadA threadA = new P98ThreadA(service);
        threadA.setName("A");
        threadA.start();
        P98ThreadB threadB = new P98ThreadB(service);
        threadB.setName("B");
        threadB.start();
        P98ThreadC threadC = new P98ThreadC(service);
        threadC.setName("C");
        threadC.start();

    }
}
