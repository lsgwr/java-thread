/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 上午12:10
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3com;

public class P134ThreadB extends Thread {
    private P134MyList list;

    public P134ThreadB(P134MyList list) {
        this.list = list;
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (list.size() == 5) {
                    System.out.println("==5了，线程要退出啦！");
                    throw new InterruptedException();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
