/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 下午8:47
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3com;

import java.io.PipedOutputStream;
import java.io.PipedWriter;

public class P175ThreadWrite extends Thread {
    private P174WriteData writeData;

    private PipedWriter out;

    public P175ThreadWrite(P174WriteData writeData, PipedWriter out) {
        this.writeData = writeData;
        this.out = out;
    }

    @Override
    public void run() {
        writeData.writeMethod(out);
    }
}
