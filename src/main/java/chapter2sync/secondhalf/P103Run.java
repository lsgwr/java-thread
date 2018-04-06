/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/6 下午6:12
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync.secondhalf;

public class P103Run {
    public static void main(String[] args) {
        P102Service service = new P102Service();
        P103ThreadA threadA = new P103ThreadA(service);
        threadA.setName("A");
        threadA.start();
        P103ThreadB threadB = new P103ThreadB(service);
        threadB.setName("B");
        threadB.start();
    }
}
