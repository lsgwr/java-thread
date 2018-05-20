/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/3/25 下午9:52
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync.firsthalf;

public class P69Test {
    public static void main(String[] args) throws InterruptedException {
        P68Service service = new P68Service();
        P68ThreadA threadA = new P68ThreadA(service);
        threadA.setName("a");
        threadA.start();
        Thread.sleep(500);
        P68ThreadB threadB = new P68ThreadB(service);
        threadB.setName("b");
        threadB.start();
    }
}
