/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/9 上午12:23
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter4reen;

public class P214Run {
    public static void main(String[] args) {
        P213MyService myService = new P213MyService();
        P214MyThreadA threadA = new P214MyThreadA(myService);
        threadA.start();
        P214MyThreadB threadB = new P214MyThreadB(myService);
        threadB.start();
    }
}
