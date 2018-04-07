/***********************************************************
 * @Description : wait等待的条件发生变化，也容易在造成逻辑混乱
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 下午4:34
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3com;

public class P155Add {
    private String lock;

    public P155Add(String lock) {
        this.lock = lock;
    }

    public void add() {
        synchronized (lock) {
            P156ValueObject.list.add("anyString");
            lock.notifyAll();
        }
    }
}
