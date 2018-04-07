/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 下午6:23
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3com;

public class P168Consumer {
    private P168MyStack myStack;

    public P168Consumer(P168MyStack myStack) {
        this.myStack = myStack;
    }

    public void popService() {
        System.out.println("pop = " + myStack.pop());
    }
}
