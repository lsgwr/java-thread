/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/3/27 下午11:30
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync.firsthalf;

public class P79Task {
    public static void main(String[] args) {
        P78ObjectService service = new P78ObjectService();
        P78ThreadA threadA = new P78ThreadA(service);
        threadA.setName("a");
        threadA.start();
        P78ThreadB threadB = new P78ThreadB(service);
        threadB.setName("b");
        threadB.start();
    }
}
