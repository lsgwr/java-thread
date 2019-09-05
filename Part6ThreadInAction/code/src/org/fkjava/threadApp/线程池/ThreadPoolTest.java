/**
 * 
 */
package org.fkjava.threadApp.线程池;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Long
 * Version:1.0
 * 
 * 线程池
 */
public class ThreadPoolTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//通过Executors的静态方法获取一个线程池         newFixedThreadPool(3):创建容量为3的线程池
		ExecutorService  executorService = Executors.newFixedThreadPool(3);
		
        //创建Runnable实现类ThreadTest的实例
		ThreadTest threadTest = new ThreadTest();
		
		//将Runnable实现类ThreadTest的实例提交给线程池，线程池会将  threadTest包装成一个线程，放在池子中，并且会通知CPU调用run方法
		//创建一个线程放在线程池，并执行 run方法
		executorService.submit(threadTest);
		
		//创建一个线程放在线程池，并执行 run方法
		executorService.submit(threadTest);
		
		//创建一个线程放在线程池，并执行 run方法
		executorService.submit(threadTest);
		
		//从池子中拿出一个线程并执行
		executorService.submit(threadTest);
		
		//关闭线程池
		executorService.shutdown();

		
	}

}


class ThreadTest implements Runnable{

	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		for (int i = 0; i < 3; i++) {
			System.out.println(Thread.currentThread().getName()+"---i:"+i);
		}
		System.out.println("------------------------------------");
		
	}
	
}
