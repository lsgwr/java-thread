/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/6 下午6:26
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync.secondhalf;

public class P106Run {
    public static void main(String[] args) {
        P105Service service = new P105Service();
        P105ThreadA threadA = new P105ThreadA(service);
        threadA.start();
        P105ThreadB threadB = new P105ThreadB(service);
        threadB.start();
    }
}
