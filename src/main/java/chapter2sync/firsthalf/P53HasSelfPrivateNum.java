/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/3/19 上午12:16
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync.firsthalf;

public class P53HasSelfPrivateNum {
    public void addI(String username) throws InterruptedException {
        int num = 0;
        if (username.equals("a")) {
            num = 100;
            System.out.println("a set over!");
            Thread.sleep(2000);
        } else {
            num = 200;
            System.out.println("b set over!");
        }
        System.out.println(username + " num = " + num);
    }
}
