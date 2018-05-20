/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/9 下午11:58
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter4reen;

public class P231Run {
    public static void main(String[] args) throws InterruptedException {
        P230Service service = new P230Service();
        P231MyThread thread = new P231MyThread(service);
        thread.start();
        Thread.sleep(3000);
        thread.interrupt();
    }
}
