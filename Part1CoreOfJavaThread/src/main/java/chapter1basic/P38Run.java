/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/3/18 下午8:54
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter1basic;

public class P38Run {
    public static void main(String[] args) throws InterruptedException {
        final P38SynchronizedObject obj = new P38SynchronizedObject();
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                obj.printString();
            }
        };
        thread1.setName("a");
        thread1.start();

        Thread.sleep(1000);

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                System.out.println("thread2启动了，但进入不了printString()方法！只打印了1个begin");
                System.out.println("因为printString()方法被a线程锁定并且永远suspend暂停了！");
                obj.printString();
            }
        };
        thread2.start();
    }
}
