/***********************************************************
 * @Description : 简易的倒计时器
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/5/22 00:08
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package C01走进Java世界中的多线程;

public class P16SimpleTimer {
    private static int count;

    private static int countDown() {
        return count--;
    }

    public static void main(String[] args) throws InterruptedException {
        // 不传参默认10
        count = args.length >= 1 ? Integer.valueOf(args[0]) : 10;
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
/**
 * Remaining : 9seconds(s)
 * Remaining : 8seconds(s)
 * Remaining : 7seconds(s)
 * Remaining : 6seconds(s)
 * Remaining : 5seconds(s)
 * Remaining : 4seconds(s)
 * Remaining : 3seconds(s)
 * Remaining : 2seconds(s)
 * Remaining : 1seconds(s)
 * Remaining : 0seconds(s)
 * Down.
 */
