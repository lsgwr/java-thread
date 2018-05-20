/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 下午4:46
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3com;

public class P157Run {
    public static void main(String[] args) throws InterruptedException {
        String lock = new String("");
        P155Add add = new P155Add(lock);
        P155Subtract subtract = new P155Subtract(lock);
        P156ThreadSubtract threadSubtract1 = new P156ThreadSubtract(subtract);
        threadSubtract1.setName("threadSubtract1");
        threadSubtract1.start();
        P156ThreadSubtract threadSubtract2 = new P156ThreadSubtract(subtract);
        threadSubtract2.setName("threadSubtract2");
        threadSubtract2.start();
        Thread.sleep(1000);
        P156ThreadAdd threadAdd = new P156ThreadAdd(add);
        threadAdd.setName("threadAdd");
        threadAdd.start();
    }
}
