/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/9 上午12:08
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter4reen;

public class P212ThreadA extends Thread{
    private P211MyService myService;

    public P212ThreadA(P211MyService myService) {
        this.myService = myService;
    }


    @Override
    public void run() {
        myService.awaitA();
    }
}
