/**
 * 
 */
package org.fkjava.threadApp.createThread_ThirdMethod;

/**
 * @author Long
 * Version:1.0
 *创建线程的方式有三种
 *1、实现Runnable接口，并重写run方法
 *
 */
public class MyThread_02  implements Runnable{
	
	
	
     public static void main(String[] args) {
    	 
    	 //创建MyThread_02实例
    	 MyThread_02 mythread = new MyThread_02();
    	 
    	 
    	 //创建线程实例,对Runnable进行包装
    	 Thread thread = new Thread(mythread);
    	 //设置线程的名字
    	 thread.setName("打开小明聊天窗口");
    	 //让线程就绪
    	 thread.start();
    	 
    	 
    	 
     	//因为Runnable是一个函数式接口
     	 Runnable runnable = new Runnable() {
 			/*
 			 * 重写Runnable的run方法
 			 */
 			@Override
 			public void run() {
 				// TODO Auto-generated method stub
 				 for (int k = 0; k < 50; k++) {
 			 			//Thread.currentThread():获取当前线程         getName：获取当前线程的名字
 			 			System.out.println("线程名字为:"+Thread.currentThread().getName()+"=====k===="+k);
 			             
 			 		}
 			}
     		  
     		 
     	 };
     	 
     	 //将Runnable实例包装成 Thread的实例
     	 Thread thread02 = new Thread(runnable);
     	 thread02.setName("打开阿毛聊天窗口");
     	 //让线程就绪
     	 thread02.start();
     	 
     	 
     	 //用Lambda表达式进行简化
     	 Runnable runnable02 = () ->{
     		 for (int k = 0; k < 50; k++) {
		 			//Thread.currentThread():获取当前线程         getName：获取当前线程的名字
		 			System.out.println("线程名字为:"+Thread.currentThread().getName()+"=====k===="+k);
		             
		 		}
     		 
     	 };
     	 
     	 //将Runnable实例包装成 Thread的实例
     	 Thread thread03 = new Thread(runnable02);
     	 thread03.setName("打开无忌聊天窗口");
     	 //让线程就绪
     	 thread03.start();
     	 
     	 
     	 
    	 
    	 
    	 for (int i = 0; i < 50; i++) {
 			//Thread.currentThread():获取当前线程         getName：获取当前线程的名字
 			System.out.println("线程名字为:"+Thread.currentThread().getName()+"=====i===="+i);
             
 		}
    	 
    	
		
	}

	/* 
	 * 重写Runnable接口中的run方法
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 50; i++) {
			//Thread.currentThread():获取当前线程         getName：获取当前线程的名字
			System.out.println("线程名字为:"+Thread.currentThread().getName()+"=====i===="+i);
            
		}
		
	}
}
