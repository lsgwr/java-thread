/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/6 上午11:26
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync.firsthalf;

public class P86Run {
    public static void main(String[] args) {
        P86Service service = new P86Service();
        P86ThreadA threadA = new P86ThreadA(service);
        threadA.setName("A");
        threadA.start();
        P86ThreadB threadB = new P86ThreadB(service);
        threadB.setName("B");
        threadB.start();
    }

}
