/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/9 下午10:51
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter4reen;

public class P224Run {
    public static void main(String[] args) {
        final P224Service service1 = new P224Service(true);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                service1.serviceMethod();
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        final P224Service service2 = new P224Service(false);
        runnable = new Runnable() {
            @Override
            public void run() {
                service2.serviceMethod();
            }
        };
        thread = new Thread(runnable);
        thread.start();

    }
}
