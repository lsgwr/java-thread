/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 下午10:15
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3com;

public class P191Run {
    public static ThreadLocal t1 = new ThreadLocal();

    public static void main(String[] args) {
        if (t1.get() == null) {
            System.out.println("从未放置过值");
            t1.set("设置了一个值");
        }
        System.out.println(t1.get());
        System.out.println(t1.get());
    }
}
