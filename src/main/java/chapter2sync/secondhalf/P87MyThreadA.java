/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/6 下午12:01
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync.secondhalf;

public class P87MyThreadA extends Thread {
    private P87MyList list;

    public P87MyThreadA(P87MyList list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            list.add("threadA" + (i + 1));
        }
    }
}
