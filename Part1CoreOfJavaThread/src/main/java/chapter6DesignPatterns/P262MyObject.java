/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/11 下午10:46
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter6DesignPatterns;

public class P262MyObject {
    private static P262MyObject myObject = new P262MyObject();

    public P262MyObject() {
    }

    public static P262MyObject getInstance() {
        return myObject;
    }
}
