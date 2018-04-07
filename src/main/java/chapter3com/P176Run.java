/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 下午8:46
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3com;

import java.io.*;

public class P176Run {
    public static void main(String[] args) throws IOException, InterruptedException {
        P174WriteData writeData = new P174WriteData();
        P174ReadData readData = new P174ReadData();
        PipedReader in = new PipedReader();
        PipedWriter out = new PipedWriter();
        // 输入和输出相连
        out.connect(in);
        P175ThreadRead threadRead = new P175ThreadRead(readData, in);
        threadRead.start();

        Thread.sleep(2000);
        P175ThreadWrite threadWrite = new P175ThreadWrite(writeData, out);
        threadWrite.start();
    }
}
