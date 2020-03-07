/**
 * 
 */
package org.fkjava.threadApp.常用方法;

/**
 * @author Long
 * Version:1.0
 * 线程中常用方法讲解
 */
public class ThreadTest extends Thread{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		  ThreadTest thread = new ThreadTest();
		  thread.setName("线程一");
		  //设置线程的优先级
		  thread.setPriority(Thread.MIN_PRIORITY);
		  //设置为后台线程     最后死亡，最后死亡不代表最后执行完毕
		  thread.setDaemon(true);
		  //让线程就绪
		  thread.start();
		  

		  for (int i = 0; i < 50; i++) {
			 //获取当前线程实例
			Thread thread2 = Thread.currentThread();
			//获取线程的名字，可以重复
			String name = thread2.getName();
			//获取线程id，线程id是不会重复的，好比人的省份证一样不会重写
			long id = thread2.getId();
			

			//获取线程的优先级     如果线程的优先级越大，说明获取CPU的执行机会越大
			int priority = thread2.getPriority();
			System.out.println("name:"+name+"   id："+id +" 优先级："+priority);
		}
		  
		  
		
		  
	}

	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		 for (int i = 0; i < 50; i++) {
			 //获取当前线程实例
			Thread thread = Thread.currentThread();
			//获取线程的名字，可以重复
			String name = thread.getName();
			//获取线程id，线程id是不会重复的，好比人的省份证一样不会重写
			long id = thread.getId();
			

			//获取线程的优先级     如果线程的优先级越大，说明获取CPU的执行机会越大
			int priority = thread.getPriority();
			System.out.println("name:"+name+"   id："+id +" 优先级："+priority);
		}
	}
	
	
	

}
