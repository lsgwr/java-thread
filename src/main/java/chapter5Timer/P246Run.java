/***********************************************************
 * @Description : 定时时间早于当前时间，直接运行
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/10 下午10:59
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter5Timer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class P246Run {
    private static Timer timer = new Timer();

    static public class MyTask1 extends TimerTask {
        @Override
        public void run() {
            try {
                System.out.println("1 begin 运行了！时间为：" + new Date());
                Thread.sleep(10000);
                System.out.println("1   end 运行了！时间为：" + new Date());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static public class MyTask2 extends TimerTask {
        @Override
        public void run() {
            System.out.println("2 begin 运行了！时间为：" + new Date());
            System.out.println("运行了！时间为：" + new Date());
            System.out.println("2   end 运行了！时间为：" + new Date());
        }
    }

    public static void main(String[] args) throws ParseException {
        MyTask1 task1 = new MyTask1();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString1 = "2018-04-10 23:31:00";
        Date dateRef1 = sdf1.parse(dateString1);
        System.out.println("字符串1时间为：" + dateRef1.toLocaleString() + ", 当前时间为：" + new Date().toLocaleString());
        timer.schedule(task1, dateRef1);

        MyTask2 task2 = new MyTask2();
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString2 = "2018-04-10 23:31:05";
        Date dateRef2 = sdf1.parse(dateString2);
        System.out.println("字符串2时间为：" + dateRef2.toLocaleString() + ", 当前时间为：" + new Date().toLocaleString());
        timer.schedule(task2, dateRef2);
    }
}
