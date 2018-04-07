/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 下午9:08
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3com;

public class P177DBTools {
    /**
     * 当前是A还是B在运行
     */
    volatile private boolean prevIsA = false;

    synchronized public void backupA() {
        try {
            while (prevIsA == true) {
                wait();
            }

            for (int i = 0; i < 5; i++) {
                System.out.println("* * * * *");
            }
            prevIsA = true;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public void backupB() {
        try {
            while (prevIsA == false) {
                wait();
            }

            for (int i = 0; i < 5; i++) {
                System.out.println("- - - - -");
            }
            prevIsA = false;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
