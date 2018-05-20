/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/9 下午10:56
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter4reen;

public class P226Run {
    public static void main(String[] args) {
        final P226Service service = new P226Service(true);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                service.serviceMethod();
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
