/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 下午9:23
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3com;

public class P181Test {
    public static void main(String[] args) throws InterruptedException {
        P180MyThread myThread = new P180MyThread();
        myThread.start();
        myThread.join();
        System.out.println("等myThread执行完再执行,通过join做到了！");
    }
}
