/***********************************************************
 * @Description : 对象监视器是不同对象，执行结果是异步地
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/6 上午11:35
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync;

public class P86Service {
    private String anyString=new String();
    public void a(){
        try {
            synchronized (anyString){
                System.out.println("a begin");
                Thread.sleep(3000);
                System.out.println("a   end");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public void b(){
        System.out.println("b begin");
        System.out.println("b   end");
    }
}
