/***********************************************************
 * @Description : 可重入锁：在一个synchronized方法内部调用本类的
 *                其他synchronized方法，是永远可以得到锁的
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/3/20 上午12:37
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync.firsthalf;

public class P66Run {
    public static void main(String[] args) {
        P66MyThread thread = new P66MyThread();
        thread.start();
    }
}
