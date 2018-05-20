/***********************************************************
 * @Description : 当其他线程执行x对象中的synchronized同步方法是呈
 *                现同步效果
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/6 下午1:57
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync.secondhalf;

public class P93MyObject {
    synchronized public void speedPrintString() {
        System.out.println("speedPrintString getLock Time = " + System.currentTimeMillis() + ", run ThreadName = " + Thread.currentThread().getName());
        System.out.println("-------------------------------------");
        System.out.println("speedPrintString releaseLock Time = " + System.currentTimeMillis() + ", run ThreadName = " + Thread.currentThread().getName());
    }
}
