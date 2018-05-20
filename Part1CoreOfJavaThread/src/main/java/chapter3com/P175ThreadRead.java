/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 下午8:47
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3com;

import java.io.PipedReader;

public class P175ThreadRead extends Thread {
    private P174ReadData readData;

    private PipedReader in;

    public P175ThreadRead(P174ReadData readData, PipedReader in) {
        this.readData = readData;
        this.in = in;
    }

    @Override
    public void run() {
        readData.readMethod(in);
    }
}
