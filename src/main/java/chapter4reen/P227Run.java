/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/9 下午11:04
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter4reen;

public class P227Run {
    public static void main(String[] args) {
        final P227MyService service = new P227MyService();
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
        // 打断线程
        b.interrupt();
        System.out.println("main end");
    }
}
