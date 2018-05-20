/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/6 下午9:51
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync.secondhalf;

public class P120Run {
    public static void main(String[] args) {
        P120PrintString printString = new P120PrintString();
        new Thread(printString).start();
        System.out.println("我要停止它！stopThread = " + Thread.currentThread().getName());
        printString.setContinuePrint(false);
    }
}
