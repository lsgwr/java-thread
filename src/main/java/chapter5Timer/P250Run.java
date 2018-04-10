/***********************************************************
 * @Description : 将自身从任务队列中清除
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/10 下午11:35
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter5Timer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class P250Run {
    static public class MyTaskA extends TimerTask {

        @Override
        public void run() {
            System.out.println("A 运行了！时间为：" + new Date());
            this.cancel();
        }
    }

    static public class MyTaskB extends TimerTask {

        @Override
        public void run() {
            System.out.println("B 运行了！时间为：" + new Date());
        }
    }

    public static void main(String[] args) throws ParseException {
        Timer timer = new Timer();
        MyTaskA taskA = new MyTaskA();
        MyTaskB taskB = new MyTaskB();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = "2018-04-10 23:06:00";
        Date dateRef = sdf.parse(dateString);
        System.out.println("字符串时间为：" + dateRef.toLocaleString() + ", 当前时间为：" + new Date().toLocaleString());
        timer.schedule(taskA, dateRef, 4000);
        timer.schedule(taskB, dateRef, 4000);
    }
}
