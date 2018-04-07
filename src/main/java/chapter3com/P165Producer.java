/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 下午6:22
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3com;

public class P165Producer {
    private P164MyStack myStack;

    public P165Producer(P164MyStack myStack) {
        this.myStack = myStack;
    }

    public void pushService() {
        myStack.push();
    }
}
