/***********************************************************
 * @Description : 使用了不是同一个对象监视器，所以是异步地
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/6 下午1:47
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync.secondhalf;

public class P93Run {
    public static void main(String[] args) {


        P91Service service = new P91Service();
        P91MyObject object1 = new P91MyObject();
        P91MyObject object2 = new P91MyObject();
        P92ThreadA threadA = new P92ThreadA(service, object1);
        threadA.setName("a");
        threadA.start();
        P92ThreadB threadB = new P92ThreadB(service, object2);
        threadB.setName("b");
        threadB.start();
    }
}
