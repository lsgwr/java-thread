/***********************************************************
 * @Description : 自定义线程类中的实例变量共享
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/3/18 下午5:34
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter1basic;

public class P10MyThread extends Thread {
    private int count = 5;

    public P10MyThread(String name) {
        super();
        // 设置线程名
        this.setName(name);
    }

    @Override
    public void run() {
        super.run();
        while (count > 0) {
            count--;
            System.out.println("由 " + currentThread().getName() + " 计算，count = " + count);
        }
    }
}

