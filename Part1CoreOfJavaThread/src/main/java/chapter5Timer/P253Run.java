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

public class P253Run {

    static public class MyTask extends TimerTask {
        @Override
        public void run() {
            System.out.println("运行了！时间为：" + new Date());
        }
    }

    public static void main(String[] args) throws ParseException {
        MyTask task = new MyTask();
        Timer timer = new Timer();
        System.out.println("当前时间："+new Date());
        timer.schedule(task, 7000);
    }
}
