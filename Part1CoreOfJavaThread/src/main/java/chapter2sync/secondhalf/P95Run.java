/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/6 下午2:09
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync.secondhalf;

public class P95Run {
    public static void main(String[] args) throws InterruptedException {
        P94Service service = new P94Service();
        P93MyObject object = new P93MyObject();
        P94ThreadA threadA = new P94ThreadA(service, object);
        threadA.setName("a");
        threadA.start();
        Thread.sleep(200);
        P94ThreadB threadB = new P94ThreadB(object);
        threadB.setName("b");
        threadB.start();
    }
}
