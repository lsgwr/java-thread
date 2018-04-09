/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/9 下午11:42
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter4reen;

public class P228Run {
    public static void main(String[] args) {
        final P228MyService service = new P228MyService();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                service.waitMethod();
            }
        };

        Thread a = new Thread(runnable);
        a.setName("A");
        a.start();
        Thread b = new Thread(runnable);
        b.setName("B");
        b.start();
    }
}
