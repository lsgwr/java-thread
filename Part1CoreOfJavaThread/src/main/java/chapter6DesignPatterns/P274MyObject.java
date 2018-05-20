/***********************************************************
 * @Description : 静态代码块实现单例模式
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/12 上午12:12
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter6DesignPatterns;

public class P274MyObject {
    private static P274MyObject myObject = null;

    private static class MyObjectHandler {
    }


    public P274MyObject() {
    }

    /**
     * 静态代码块会在类实例化前执行一次，并且后面再不会执行。和静态内部类差不多
     */
    static {
        myObject = new P274MyObject();
    }

    public static P274MyObject getInstance() {
        return myObject;
    }
}
