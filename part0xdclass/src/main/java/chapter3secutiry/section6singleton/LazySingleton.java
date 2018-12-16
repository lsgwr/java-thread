package chapter3secutiry.section6singleton;

/***********************************************************
 * @Description : 懒汉式单例模式，需要的时候进行实例化。
 * 懒汉式想线程安全是很难地，而且非常消耗性能推荐使用饿汉式
 * @author      : 梁山广(Liang Shan Guang)
 * @date        : 2018-12-16 20:14
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
public class LazySingleton {

    /**
     * volatile可以防止指令重排
     */
    private static volatile LazySingleton lazySingleton = null;

    private LazySingleton() {

    }

    public static LazySingleton getInstance() {
        //判断实例是否为空，为空则实例化
        if (null == lazySingleton) {
            //模拟实例化时耗时的操作
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 双重判空锁
            synchronized (LazySingleton.class) {
                if (null == lazySingleton) {
                    lazySingleton = new LazySingleton();
                }
            }
        }
        //否则直接返回
        return lazySingleton;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                System.out.println(LazySingleton.getInstance());
            }).start();
        }
    }

}
