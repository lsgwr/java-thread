/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/9 下午9:46
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter4reen;

public class P217RunFair {
    public static void main(String[] args) {
        // true是公平锁(执行基本按照start的顺序来),false是不公平锁(执行时抢占地，乱序地)
        final P216Service service = new P216Service(false);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("$$$$$ 线程 " + Thread.currentThread().getName() + " 运行啦！");
                service.serviceMethod();
            }
        };

        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(runnable);
        }

        for (int i = 0; i < 10; i++) {
            threads[i].start();
        }
    }
}
