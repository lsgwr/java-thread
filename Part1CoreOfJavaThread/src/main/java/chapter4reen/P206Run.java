/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/8 下午10:14
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter4reen;

public class P206Run {
    public static void main(String[] args) {
        P206MyService myService = new P206MyService();
        P206MyThreadA a = new P206MyThreadA(myService);
        a.start();
    }
}
