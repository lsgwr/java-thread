/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/3/26 下午10:43
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync.firsthalf;

public class P75Run {
    public static void main(String[] args) {
        P74ObjectService service = new P74ObjectService();
        P74ThreadA threadA = new P74ThreadA(service);
        threadA.setName("a");
        threadA.start();
        P74ThreadB threadB = new P74ThreadB(service);
        threadB.setName("b");
        threadB.start();
    }
}
