/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 下午9:14
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3com;

public class P178Run {
    public static void main(String[] args) {
        P177DBTools dbTools = new P177DBTools();
        for (int i = 0; i < 20; i++) {
            P178BackupB output = new P178BackupB(dbTools);
            output.start();
            P178BackupA input = new P178BackupA(dbTools);
            input.start();
        }
    }
}
