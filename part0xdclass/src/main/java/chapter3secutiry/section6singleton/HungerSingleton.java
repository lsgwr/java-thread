package chapter3secutiry.section6singleton;

/***********************************************************
 * @Description : 饿汉式单例模式：在类加载的时候，就已经进行实例化，
 * 无论之后用不用到。如果该类比较占内存，之后又没用到，就白白浪费了资源。
 *                 IDEA可以在创建类的时候直接选Singleton模式
 * @author      : 梁山广(Liang Shan Guang)
 * @date        : 2018-12-16 20:08
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
public class HungerSingleton {
    private static HungerSingleton ourInstance = new HungerSingleton();

    public static HungerSingleton getInstance() {
        return ourInstance;
    }

    private HungerSingleton() {
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                System.out.println(HungerSingleton.getInstance().hashCode());
            }).start();
        }
    }
}
