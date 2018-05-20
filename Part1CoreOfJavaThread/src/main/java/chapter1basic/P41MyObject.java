/***********************************************************
 * @Description : suspend与resume方法的缺点---不同步
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/3/18 下午9:02
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter1basic;

public class P41MyObject {
    private String username = "l";
    private String password = "ll";

    public void setValue(String username, String password) {
        this.username = username;
        if (Thread.currentThread().getName().equals("a")) {
            System.out.println("停止a线程！");
            Thread.currentThread().suspend();
        }
        this.password = password;
    }

    public void printUsenameAndPassword() {
        System.out.println("username = " + username + ", password = " + password);
    }
}
