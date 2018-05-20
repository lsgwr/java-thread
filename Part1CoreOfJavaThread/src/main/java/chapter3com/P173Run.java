/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 下午8:46
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3com;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class P173Run {
    public static void main(String[] args) throws IOException, InterruptedException {
        P172WriteData writeData = new P172WriteData();
        P172ReadData readData = new P172ReadData();
        PipedInputStream in = new PipedInputStream();
        PipedOutputStream out = new PipedOutputStream();
        // 输入和输出相连
        out.connect(in);
        P173ThreadRead threadRead = new P173ThreadRead(readData, in);
        threadRead.start();

        Thread.sleep(2000);
        P173ThreadWrite threadWrite = new P173ThreadWrite(writeData, out);
        threadWrite.start();
    }
}
