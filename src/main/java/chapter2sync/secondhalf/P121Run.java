/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/6 下午9:58
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync.secondhalf;

public class P121Run {
    public static void main(String[] args) throws InterruptedException {
        P121RunThread thread=new P121RunThread();
        thread.start();
        Thread.sleep(1000);
        thread.setRunning(false);
        System.out.println("已经赋值为false了！");
    }
}
