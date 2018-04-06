/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/6 下午5:38
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync.secondhalf;

public class P102Run {
    public static void main(String[] args) {
        P101Service service1 = new P101Service();
        P101Service service2 = new P101Service();
        P101ThreadA threadA = new P101ThreadA(service1);
        threadA.setName("A");
        threadA.start();
        P101ThreadB threadB = new P101ThreadB(service2);
        threadB.setName("B");
        threadB.start();
    }

}
