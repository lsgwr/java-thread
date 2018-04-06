/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/6 下午9:38
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync.secondhalf;

public class P120PrintString implements Runnable{
    private boolean continuePrint = true;

    public boolean isContinuePrint() {
        return continuePrint;
    }

    public void setContinuePrint(boolean continuePrint) {
        this.continuePrint = continuePrint;
    }

    public void printString() {
        try {
            while (continuePrint == true) {
                System.out.println("run printString method threadName = " + Thread.currentThread().getName());
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        printString();
    }
}
