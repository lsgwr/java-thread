/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 下午10:59
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter4reen;

public class P201Run {
    public static void main(String[] args) {
        P201MyService service=new P201MyService();
        P201MyThread thread1=new P201MyThread(service);
        P201MyThread thread2=new P201MyThread(service);
        P201MyThread thread3=new P201MyThread(service);
        P201MyThread thread4=new P201MyThread(service);
        P201MyThread thread5=new P201MyThread(service);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
}
