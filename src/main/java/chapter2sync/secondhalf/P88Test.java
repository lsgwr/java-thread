/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/6 下午12:03
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync.secondhalf;

public class P88Test {
    public static void main(String[] args) {
        P87MyList list = new P87MyList();
        P87MyThreadA threadA = new P87MyThreadA(list);
        threadA.setName("A");
        threadA.start();
        P87MyThreadB threadB = new P87MyThreadB(list);
        threadB.setName("B");
        threadB.start();
    }
}
