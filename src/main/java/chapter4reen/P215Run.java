/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/9 上午12:31
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter4reen;

public class P215Run {
    public static void main(String[] args) {
        P215MyService service = new P215MyService();
        P215MyThreadA[] threadAS = new P215MyThreadA[10];
        P215MyThreadB[] threadBS = new P215MyThreadB[10];
        for (int i = 0; i < 10; i++) {
            threadAS[i] = new P215MyThreadA(service);
            threadBS[i] = new P215MyThreadB(service);
            threadAS[i].start();
            threadBS[i].start();
        }
    }
}
