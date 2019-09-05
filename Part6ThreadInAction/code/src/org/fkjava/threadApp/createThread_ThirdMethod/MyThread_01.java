/**
 * 
 */
package org.fkjava.threadApp.createThread_ThirdMethod;

/**
 * @author Long
 * Version:1.0
 *创建线程的方式有三种
 *1、继承 Thread,并重写Thread类中的run方法，通过调用start方法，让线程就绪
 *
 */
public class MyThread_01 extends Thread{
	
	
	

	/* 
	 * 重写线程父类Thread的run方法
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 50; i++) {
			//System.out.println("线程名字为:"+Thread.currentThread().getName()+"=====i===="+i);	
			System.out.println("线程名字为:"+this.getName()+"=====i===="+i);
		}
		
		
	}

	/**
	 * main方法是程序的入口方法
	 * main方法被称为主线程
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		    //手动创建线程实例
			MyThread_01 thread01 = new MyThread_01();
			//设置线程的名字
			thread01.setName("线程一");
			//start方法让线程就绪    相当于告诉CPU，线程已经就绪，这个时候CPU会在何时的时间点调用该线程的run方法
			thread01.start();
		
		
		   for (int j = 0; j < 50; j++) {
			  System.out.println("线程名字为:"+Thread.currentThread().getName()+"=====j===="+j);	
		   }
		
		
		
		   System.out.println("------------程序执行完毕---------");

	}

}
