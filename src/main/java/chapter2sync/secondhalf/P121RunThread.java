/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/6 下午9:56
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync.secondhalf;

public class P121RunThread extends Thread {
    volatile private boolean running = true;

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    @Override
    public void run() {
        System.out.println("进入run了！");
        while (running == true) {

        }
        System.out.println("线程停止了！");
    }
}
