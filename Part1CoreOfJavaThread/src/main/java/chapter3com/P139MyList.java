/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 上午12:29
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3com;

import java.util.ArrayList;
import java.util.List;

public class P139MyList {
    private static List list = new ArrayList();

    public static void add() {
        list.add("anyString");
    }

    public static int size() {
        return list.size();
    }
}
