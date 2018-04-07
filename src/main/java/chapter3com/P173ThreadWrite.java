/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 下午8:47
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3com;

import java.io.PipedOutputStream;

public class P173ThreadWrite extends Thread {
    private P172WriteData writeData;

    private PipedOutputStream out;

    public P173ThreadWrite(P172WriteData writeData, PipedOutputStream out) {
        this.writeData = writeData;
        this.out = out;
    }

    @Override
    public void run() {
        writeData.writeMethod(out);
    }
}
