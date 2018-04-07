/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 下午4:45
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3com;

public class P156ThreadSubtract extends Thread {
    private P155Subtract subtract;

    public P156ThreadSubtract(P155Subtract subtract) {
        this.subtract = subtract;
    }

    @Override
    public void run() {
        subtract.subtract();
    }


}

