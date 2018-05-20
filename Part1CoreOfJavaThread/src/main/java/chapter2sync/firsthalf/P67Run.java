/***********************************************************
 * @Description : 当存在父子类继承关系时，子类是完全可以通过"可重入锁"
 *                调用父类的同步方法的
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/3/25 下午9:23
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync.firsthalf;

public class P67Run {
    public static void main(String[] args) {
        P67MyThread thread = new P67MyThread();
        thread.start();
    }
}
