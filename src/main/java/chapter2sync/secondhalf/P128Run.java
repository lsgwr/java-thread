/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/6 下午10:35
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync.secondhalf;

public class P128Run {
    public static void main(String[] args) throws InterruptedException {
        P128MyService service = new P128MyService();
        P128MyThread[] myThreadArray = new P128MyThread[5];
        for (int i = 0; i < myThreadArray.length; i++) {
            myThreadArray[i] = new P128MyThread(service);
        }

        for (int i = 0; i < myThreadArray.length; i++) {
            myThreadArray[i].start();
        }

        Thread.sleep(1000);
        System.out.println(P128MyService.aiRef.get());
    }
}
