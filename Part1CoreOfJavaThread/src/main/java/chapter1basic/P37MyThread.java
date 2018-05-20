/***********************************************************
 * @Description : suspend实现线程停止，resume实现线程恢复
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/3/18 下午8:33
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter1basic;

public class P37MyThread extends Thread {
    private long i = 0;

    public long getI() {
        return i;
    }

    public void setI(long i) {
        this.i = i;
    }

    @Override
    public void run() {
        while (true) {
            i++;
        }
    }
}
