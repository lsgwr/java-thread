/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 下午6:23
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3com;

public class P165Consumer {
    private P164MyStack myStack;

    public P165Consumer(P164MyStack myStack) {
        this.myStack = myStack;
    }

    public void popService() {
        System.out.println("pop = " + myStack.pop());
    }
}
