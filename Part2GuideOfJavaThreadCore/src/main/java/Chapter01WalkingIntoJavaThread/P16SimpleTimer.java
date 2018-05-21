/***********************************************************
 * @Description : 简易的倒计时器
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/5/22 00:08
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package Chapter01WalkingIntoJavaThread;

public class P16SimpleTimer {
    private static int count;

    private static int countDown() {
        return count--;
    }

    public static void main(String[] args) throws InterruptedException {
        // 不传参默认60
        count = args.length >= 1 ? Integer.valueOf(args[0]) : 60;
        int remaining;
        while (true) {
            remaining = countDown();
            if (0 == remaining) {
                break;
            } else {
                System.out.println("Remaining : " + count + "seconds(s)");
            }
            Thread.sleep(1000);
        }
        System.out.println("Down.");
    }

}
