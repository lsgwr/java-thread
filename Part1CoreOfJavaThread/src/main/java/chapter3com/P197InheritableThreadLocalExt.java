/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 下午10:44
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3com;

public class P197InheritableThreadLocalExt extends InheritableThreadLocal {
    @Override
    protected Object initialValue() {
        return System.currentTimeMillis();
    }

    @Override
    protected Object childValue(Object parentValue) {
        return parentValue+" 我在子线程中加地！";
    }
}
