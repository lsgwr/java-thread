/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 下午10:29
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3com;

public class P195ThreadLocalExt extends ThreadLocal {
    @Override
    protected Object initialValue() {
        return "我是默认值，能让第一个get()到的值不再为null";
    }
}
