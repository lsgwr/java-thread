/***********************************************************
 * @Description : 执行任务的时间延时，那么下一次任务的执行时间
 *                以上一次任务的"开始时间"作为参考
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/10 下午11:56
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter5Timer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class P257Run {
    private static Timer timer = new Timer();
    private static int runCount = 0;

    static public class MyTask1 extends TimerTask {

        @Override
        public void run() {
            try {
                System.out.println("1 begin 执行啦！时间为：" + new Date().toLocaleString());
                Thread.sleep(1000);
                System.out.println("1   end 执行啦！时间为：" + new Date().toLocaleString());
                runCount++;
                if (runCount == 5) {
                    timer.cancel();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws ParseException {
        MyTask1 task = new MyTask1();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = "2018-04-10 23:06:00";
        Date dateRef = sdf.parse(dateString);
        System.out.println("字符串时间为：" + dateRef.toLocaleString() + ", 当前时间为：" + new Date().toLocaleString());
        timer.scheduleAtFixedRate(task, dateRef, 3000);
    }
}
