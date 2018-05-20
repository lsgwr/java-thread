/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/6 上午11:26
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync.firsthalf;

public class P84Run {
    public static void main(String[] args) {
        P83Service service = new P83Service();
        P83ThreadA threadA = new P83ThreadA(service);
        threadA.setName("A");
        threadA.start();
        P83ThreadB threadB = new P83ThreadB(service);
        threadB.setName("B");
        threadB.start();
    }

}
