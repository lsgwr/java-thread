/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/6 下午5:25
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync.secondhalf;

public class P96Run {
    public static void main(String[] args) {
        P96ThreadA threadA = new P96ThreadA();
        threadA.setName("A");
        threadA.start();
        P96ThreadB threadB = new P96ThreadB();
        threadB.setName("B");
        threadB.start();
    }
}
