/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 下午9:49
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3com;

public class P185ThreadA extends Thread {
    private P185ThreadB threadB;

    public P185ThreadA(P185ThreadB threadB) {
        this.threadB = threadB;
    }

    @Override
    public void run() {
        try {
            synchronized (threadB){
                threadB.start();
                // 用sleep地话，threadC必须等6s才能执行，说明sleep不释放所
                // Thread.sleep(6000);
                // 用join等1s就行，说明join是释放锁地，C可以想用地时候随便用
                threadB.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
