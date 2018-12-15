package com.xdclass.safe;

/**
 * 懒汉式单例
 * 在需要的时候再实例化
 */
public class LazySingleton {

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
