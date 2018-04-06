/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/6 下午10:13
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync.secondhalf;

public class P124Run {
    public static void main(String[] args) {
        P124MyThread[] myThreadsArray = new P124MyThread[100];
        for (int i = 0; i < 100; i++) {
            myThreadsArray[i] = new P124MyThread();
        }

        for (int i = 0; i < 100; i++) {
            myThreadsArray[i].start();
        }
    }
}
