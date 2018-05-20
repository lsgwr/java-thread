/***********************************************************
 * @Description : 静态内部类方式实现单例模式
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/12 上午12:12
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter6DesignPatterns;

public class P272MyObject {
    private static class MyObjectHandler {
        private static P272MyObject myObject = new P272MyObject();
    }

    public P272MyObject() {
    }

    public static P272MyObject getInstance() {
        return MyObjectHandler.myObject;
    }
}
