/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/12 下午11:01
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter7More;

public class P282MyThread extends Thread {
    @Override
    public void run() {
        try {
            System.out.println("begin sleep");
            Thread.sleep(10000);
            System.out.println("  end sleep");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
