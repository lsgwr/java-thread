/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/11 下午10:46
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter6DesignPatterns;

public class P264MyObject {
    private static P264MyObject myObject;

    public P264MyObject() {
    }

    public static P264MyObject getInstance() {
        // 延迟加载
        if (myObject == null) {
            myObject = new P264MyObject();
        }
        return myObject;
    }
}
