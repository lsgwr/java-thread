/***********************************************************
 * @Description : 继承自P12LoginServlet
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/3/18 下午6:08
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter1basic;

public class P13BLogin extends Thread {
    @Override
    public void run() {
        P12LoginServlet.doPost("b", "bb");
    }
}
