/***********************************************************
 * @Description : ThreadLocal 线程局部变量，每个线程各自占一个值
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2019-08-04 22:31
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter5communication.section5ThreadLocal;

public class ThreadLocalTest {
    /**
     * 初始化ThreadLocal变量为0
     */
    ThreadLocal<Integer> num = ThreadLocal.withInitial(() -> 0);

    public void inCreate() {
        Integer myNum = num.get();
        myNum++;
        System.out.println(Thread.currentThread().getName() + "----->" + myNum);
        num.set(myNum);
    }

    public static void main(String[] args) {
        ThreadLocalTest threadLocalTest = new ThreadLocalTest();
        // 注意这里下标从1开始，否则0*1000L还是0，那么Thread-0就相当于没有休眠了
        for (int i = 1; i < 4; i++) {
            int finalI = i;
            new Thread(() -> {
                while (true) {
                    threadLocalTest.inCreate();
                    try {
                        Thread.sleep(finalI * 1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
