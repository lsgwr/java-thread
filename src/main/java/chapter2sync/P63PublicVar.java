/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/3/20 上午12:07
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync;

public class P63PublicVar {
    public String username = "A";
    public String password = "AA";

    synchronized public void setValue(String username, String password) {
        try {
            this.username = username;
            Thread.sleep(5000);
            this.password = password;
            System.out.println("setValue method thread name = " + Thread.currentThread().getName() + ", username = " + username + ", password = " + password);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public void getValue() {
        System.out.println("getValue method thread name = " + Thread.currentThread().getName() + ", username = " + username + ", password = " + password);
    }
}
