/***********************************************************
 * @Description : 脏读问题
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/6 上午11:52
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync;

import java.util.ArrayList;
import java.util.List;

public class P87MyList {
    private List list = new ArrayList();

    synchronized public void add(String username) {
        System.out.println("ThreadName = " + Thread.currentThread().getName() + "执行了add方法！");
        list.add(username);
        System.out.println("ThreadName = " + Thread.currentThread().getName() + "退出了add方法！");
    }

    synchronized public int getSize() {
        System.out.println("ThreadName = " + Thread.currentThread().getName() + "执行了getSize方法！");
        int listSize = list.size();
        System.out.println("ThreadName = " + Thread.currentThread().getName() + "退出了getSize方法！");
        return listSize;
    }
}
