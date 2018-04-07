/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 下午10:17
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3com;

import java.util.Date;

public class P194ThreadA extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 20; i++) {
                if (P193Tools.t1.get()==null){
                    P193Tools.t1.set(new Date());
                }
                System.out.println("A  "+P193Tools.t1.get().getTime());
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
