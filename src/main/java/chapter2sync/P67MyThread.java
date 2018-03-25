/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/3/25 下午9:21
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync;

public class P67MyThread extends Thread {
    @Override
    public void run() {
        P67Sub sub = new P67Sub();
        sub.operateISubMethod();
    }
}
