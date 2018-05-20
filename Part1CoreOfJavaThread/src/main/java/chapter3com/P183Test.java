/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 下午9:41
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3com;

public class P183Test {
    public static void main(String[] args) throws InterruptedException {
        P183MyThread myThread = new P183MyThread();
        myThread.start();
        // 只等2s
        myThread.join(2000);
        System.out.println("  end time = "+System.currentTimeMillis());
    }
}
