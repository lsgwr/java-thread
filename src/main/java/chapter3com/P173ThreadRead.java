/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 下午8:47
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3com;

import java.io.PipedInputStream;

public class P173ThreadRead extends Thread {
    private P172ReadData readData;

    private PipedInputStream in;

    public P173ThreadRead(P172ReadData readData, PipedInputStream in) {
        this.readData = readData;
        this.in = in;
    }

    @Override
    public void run() {
        readData.readMethod(in);
    }
}
