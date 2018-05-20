/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/6 下午10:50
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync.secondhalf;

public class P131Run {
    public static void main(String[] args) throws InterruptedException {
        P130Service service = new P130Service();
        P130ThreadA threadA = new P130ThreadA(service);
        threadA.start();
        Thread.sleep(1000);
        P130ThreadB threadB = new P130ThreadB(service);
        threadB.start();
        System.out.println("已经发起停止地命令了！");
    }
}
