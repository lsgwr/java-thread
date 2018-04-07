/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 下午4:37
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3com;

public class P155Subtract {
    private String lock;

    public P155Subtract(String lock) {
        this.lock = lock;
    }

    public void subtract() {
        try {
            synchronized (lock) {
                // 只有元素数非0才往下走，才能减元素，否则一直等着
                while (P156ValueObject.list.size() == 0) {
                    System.out.println("begin wait threadName = " + Thread.currentThread().getName());
                    lock.wait();
                    System.out.println("  end wait threadName = " + Thread.currentThread().getName());
                }
                P156ValueObject.list.remove(0);
                System.out.println("list size = " + P156ValueObject.list.size());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
