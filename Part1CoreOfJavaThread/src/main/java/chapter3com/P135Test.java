/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 上午12:12
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3com;

public class P135Test {
    public static void main(String[] args) {

        P134MyList list = new P134MyList();
        P134ThreadA threadA = new P134ThreadA(list);
        threadA.setName("A");
        threadA.start();
        P134ThreadB threadB = new P134ThreadB(list);
        threadB.setName("B");
        threadB.start();
    }
}
