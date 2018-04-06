/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/6 下午6:12
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync.secondhalf;

public class P105Run {
    public static void main(String[] args) {
        P104Service service = new P104Service();
        P104ThreadA threadA = new P104ThreadA(service);
        threadA.setName("A");
        threadA.start();
        P104ThreadB threadB = new P104ThreadB(service);
        threadB.setName("B");
        threadB.start();
    }
}
