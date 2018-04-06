/***********************************************************
 * @Description : 关键字synchronized可以使多个线程访问同一个资源
 *                具有同步性，而且它还具有将线程工作内存中的私有变
 *                量与公共内存中的变量同步的功能
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/6 下午10:42
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync.secondhalf;

public class P130Service {
    private boolean continueRun = true;

    public void runMethod() {
        String anyString = new String();

        while (continueRun == true) {
            synchronized (anyString) {
                
            }
        }
        System.out.println("停下来了！");
    }

    public void stopMethod() {
        continueRun = false;
    }
}
