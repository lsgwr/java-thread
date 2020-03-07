/**
 * 
 */
package org.fkjava.threadApp.createThread_ThirdMethod;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author Long
 * Version:1.0
 *创建线程的方式有三种
 *1、实现Callable接口，并重写call方法
 *
 *
 */
public class MyThread_03  implements Callable<Integer>{
	
	
	
     public static void main(String[] args) {
    	 
    	 //1、创建 MyThread_03实例
    	 MyThread_03 callable = new MyThread_03();
    	 
    	 //2、创建FutureTask实例    FutureTask就是Runnable实现类
    	 FutureTask<Integer> future = new FutureTask<>(callable);
    	     	 

    	 //创建Thread实例
    	 Thread thread = new Thread(future);
    	 
    	 thread.setName("线程一");
    	 thread.start();
    	
    	
    	 
    	 
    	 
    	 for (int i = 0; i < 50; i++) {
	 			//Thread.currentThread():获取当前线程         getName：获取当前线程的名字
	 			System.out.println("线程名字为:"+Thread.currentThread().getName()+"=====i===="+i);	 
	 	}
    	 
    	
    	 try {
    		 //当线程执行完毕之后获取线程执行完毕后的返回值
        	 int count = future.get();
        	 System.out.println("count:"+count);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	
	}

	/* 
	 * 重写Callable接口中的call方法
	 */
	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		int count = 0;
		for (int k = 0; k < 50; k++) {
	 			//Thread.currentThread():获取当前线程         getName：获取当前线程的名字
	 			System.out.println("线程名字为:"+Thread.currentThread().getName()+"=====k===="+k); 
	 			count++;   
	 	}
		return count;
	}

	
}
