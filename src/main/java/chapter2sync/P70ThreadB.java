/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/3/25 下午10:09
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync;

public class P70ThreadB extends Thread {
    private P70Sub sub;

    public P70ThreadB(P70Sub sub) {
        this.sub = sub;
    }

    @Override
    public void run() {
        sub.serviceMethod();
    }
}
