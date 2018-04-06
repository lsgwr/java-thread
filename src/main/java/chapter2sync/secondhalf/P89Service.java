/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/6 下午12:50
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync.secondhalf;

public class P89Service {
    public P88MyOneList addServiceMethod(P88MyOneList list, String data) {
        try {
            // 不加synchronized会导致脏读
            synchronized (list) {
                if (list.getSize() < 1) {
                    // 模拟从远程花费2s取数据
                    Thread.sleep(2000);
                    list.add(data);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
