/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/11 下午10:46
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter6DesignPatterns;

public class P266MyObject {
    private static P266MyObject myObject;

    public P266MyObject() {
    }

    public static P266MyObject getInstance() {
        try {
            // 延迟加载
            if (myObject == null) {
                // 模拟在创建对象之前做一些准备性的工作
                Thread.sleep(3000);
                synchronized (P266MyObject.class) {
                    if (myObject == null) {
                        myObject = new P266MyObject();
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return myObject;
    }
}
