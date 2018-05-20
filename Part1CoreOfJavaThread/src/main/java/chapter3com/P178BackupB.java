/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 下午9:13
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3com;

public class P178BackupB extends Thread {
    private P177DBTools dbTools;

    public P178BackupB(P177DBTools dbTools) {
        this.dbTools = dbTools;
    }

    @Override
    public void run() {
        dbTools.backupB();
    }
}
