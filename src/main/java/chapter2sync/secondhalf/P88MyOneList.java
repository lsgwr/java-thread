/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/6 下午12:49
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync.secondhalf;

import java.util.ArrayList;
import java.util.List;

public class P88MyOneList {
    private List list = new ArrayList();

    synchronized public void add(String data) {
        list.add(data);
    }

    synchronized public int getSize() {
        return list.size();
    }
}
