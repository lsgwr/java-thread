/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/10 上午12:12
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter4reen;

public class P233Run {
    public static void main(String[] args) {
        P232Service service = new P232Service();
        P232MyThreadA threadA = new P232MyThreadA(service);
        threadA.start();
    }
}
