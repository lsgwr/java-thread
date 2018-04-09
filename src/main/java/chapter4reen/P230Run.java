/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/9 下午11:49
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter4reen;

public class P230Run {
    public static void main(String[] args) {
        final P229MyService service = new P229MyService();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "调用waitThread的时间：" + System.currentTimeMillis());
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
