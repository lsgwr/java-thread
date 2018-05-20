/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/3/25 下午10:10
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync.firsthalf;

public class P71Run {
    public static void main(String[] args) {
        P70Sub sub = new P70Sub();
        P70ThreadA threadA = new P70ThreadA(sub);
        threadA.setName("A");
        threadA.start();
        P70ThreadB threadB = new P70ThreadB(sub);
        threadB.setName("B");
        threadB.start();
    }
}
