/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/6 下午5:38
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync.secondhalf;

public class P100Run {
    public static void main(String[] args) {
        P99Service service1 = new P99Service();
        P99Service service2 = new P99Service();
        P100ThreadA threadA = new P100ThreadA(service1);
        threadA.setName("A");
        threadA.start();
        P100ThreadB threadB = new P100ThreadB(service2);
        threadB.setName("B");
        threadB.start();
    }

}
