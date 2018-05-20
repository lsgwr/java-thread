/***********************************************************
 * @Description : 可重入锁也支持在父子类继承的环境中
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/3/25 下午9:15
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync.firsthalf;

public class P67Main {
    public int i = 10;

    synchronized public void operateIMainMethod() {
        try {
            i--;
            System.out.println("main print i = " + i);
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
