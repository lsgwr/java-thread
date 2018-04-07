/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 下午4:45
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3com;

public class P156ThreadAdd extends Thread {
    private P155Add add;

    public P156ThreadAdd(P155Add add) {
        this.add = add;
    }

    @Override
    public void run() {
        add.add();
    }
}
