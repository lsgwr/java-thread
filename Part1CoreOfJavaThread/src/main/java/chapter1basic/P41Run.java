/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/3/18 下午9:06
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter1basic;

public class P41Run {
    public static void main(String[] args) throws InterruptedException {
        final P41MyObject myObject = new P41MyObject();
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                myObject.setValue("a", "aa");
            }
        };
        thread1.setName("a");
        thread1.start();
        Thread.sleep(500);
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                myObject.printUsenameAndPassword();
            }
        };
        thread2.start();
    }
}
