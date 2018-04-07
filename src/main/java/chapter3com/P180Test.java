/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 下午9:23
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3com;

public class P180Test {
    public static void main(String[] args) {
        P180MyThread myThread = new P180MyThread();
        myThread.start();
        // Thread.sleep(?); 如果想等myThread执行完再执行，这个sleep地时间并不好确定
        System.out.println("等myThread执行完再执行");
    }
}
