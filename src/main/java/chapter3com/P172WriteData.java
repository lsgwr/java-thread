/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 下午7:02
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3com;

import java.io.IOException;
import java.io.PipedOutputStream;

public class P172WriteData {
    public void writeMethod(PipedOutputStream out) {
        try {
            System.out.println("write : ");
            for (int i = 0; i < 300; i++) {
                String outData = "" + (i + 1);
                out.write(outData.getBytes());
                System.out.print(outData);
            }
            System.out.println();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
