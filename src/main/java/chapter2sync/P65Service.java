/***********************************************************
 * @Description : 锁重入
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/3/20 上午12:30
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync;

public class P65Service {
    synchronized public void service1() {
        System.out.println("service1");
        service2();
    }

    synchronized public void service2() {
        System.out.println("service2");
        service3();
    }

    synchronized public void service3() {
        System.out.println("service3");
    }


}
