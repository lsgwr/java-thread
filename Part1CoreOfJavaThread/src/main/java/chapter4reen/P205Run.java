/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 下午11:54
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter4reen;

public class P205Run {
    public static void main(String[] args) {
        P205MyService service = new P205MyService();
        P205ThreadA a = new P205ThreadA(service);
        a.start();
    }
}
