/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 下午5:02
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3com;

public class P159Consumer {
    private String lock;

    public P159Consumer(String lock) {
        this.lock = lock;
    }

    public void getValue() {
        try {
            synchronized (lock) {
                if (P159ValueObject.value.equals("")) {
                    lock.wait();
                }
                System.out.println("get的值是：" + P159ValueObject.value);
                P159ValueObject.value = "";
                lock.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
