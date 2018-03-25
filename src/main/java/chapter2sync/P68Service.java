/***********************************************************
 * @Description : 线程出现异常的时候，锁会自动释放
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/3/25 下午9:40
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync;

public class P68Service {
    synchronized public void testMethod() {
        if (Thread.currentThread().getName().equals("a")) {
            System.out.println("ThreadName = " + Thread.currentThread().getName() + " run beginTime = " + System.currentTimeMillis());
            int i = 1;
            while (i == 1) {
                if (("" + Math.random()).substring(0, 8).equals("0.123456")) {
                    System.out.println("ThreadName = " + Thread.currentThread().getName() + " run exceptionName = " + System.currentTimeMillis());
                    Integer.parseInt("a");
                }
            }
        } else {
            System.out.println("Thread B run Time = " + System.currentTimeMillis());
        }

    }
}
