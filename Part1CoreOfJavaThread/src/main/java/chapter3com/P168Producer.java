/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 下午6:22
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3com;

public class P168Producer {
    private P168MyStack myStack;

    public P168Producer(P168MyStack myStack) {
        this.myStack = myStack;
    }

    public void pushService() {
        myStack.push();
    }
}
