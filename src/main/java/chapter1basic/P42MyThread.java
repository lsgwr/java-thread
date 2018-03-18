/***********************************************************
 * @Description : yield方法，放弃当前的CPU资源
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/3/18 下午9:20
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter1basic;

public class P42MyThread extends Thread {
    @Override
    public void run() {
        long beginTime = System.currentTimeMillis();
        int count = 0;
        for (int i = 0; i < 50000000; i++) {
            // 多次yield需要再重新获取时间片，会大量消耗时间。注释掉后可以时间大大减少
            Thread.yield();
            count = count + (i + 1);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("用时：" + (endTime - beginTime) + "毫秒");
    }
}
