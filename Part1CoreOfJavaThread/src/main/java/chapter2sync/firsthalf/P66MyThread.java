/***********************************************************
 * @Description : 
 * @author      : 梁山广(Liang Shan Guang)
 * @date        : 2018/3/20 上午12:36
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync.firsthalf;

public class P66MyThread extends Thread {
    @Override
    public void run() {
        P65Service service = new P65Service();
        service.service1();
    }
}
