/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/3/25 下午10:24
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync.firsthalf;

public class P76Task {
    /**
     * 全局变量线程共享
     */
    private String getData1;
    private String getData2;

    public void doLongTimeTask() {
        try {
            System.out.println("begin task");
            Thread.sleep(3000);
            // 局部变量线程独有，类似HRDG中出现过的一个问题
            String privateGetData1 = "长时间处理任务后从远程返回的值1：threadName = " + Thread.currentThread().getName();
            String privateGetData2 = "长时间处理任务后从远程返回的值2：threadName = " + Thread.currentThread().getName();
            synchronized (this) {
                getData1 = privateGetData1;
                getData2 = privateGetData2;
            }
            System.out.println(getData1);
            System.out.println(getData2);
            System.out.println("end task");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
