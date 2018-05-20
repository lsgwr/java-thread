/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 下午10:33
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3com;

import java.util.Date;

public class P196ThreadLocalExt extends ThreadLocal {
    @Override
    protected Object initialValue() {
        return System.currentTimeMillis();
    }
}
