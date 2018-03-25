/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/3/25 下午9:19
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync;

public class P67Sub extends P67Main{
    synchronized public void operateISubMethod(){
        try {
            while (i>0){
                i--;
                System.out.println("sub print i = "+i);
                Thread.sleep(100);
                this.operateIMainMethod();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
