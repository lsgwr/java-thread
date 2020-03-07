/**
 * 
 */
package org.fkjava.threadApp.常用方法;

/**
 * @author Long
 * Version:1.0
 * 线程常用方法讲解
 */
public class ThreadSleep extends Thread{

	/**
	 * 主线程 main方法
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		  ThreadSleep thread = new ThreadSleep();
		  thread.setName("线程一");
		  //让线程就绪
		  thread.start();
		  

		  for (int j = 0; j < 50; j++) {
				System.out.println(Thread.currentThread().getName()+"----j---"+j);
		}
		  
	}

	//重写Thread中的run方法
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		 
		 for (int i = 0; i < 50; i++) {
			 try {
				 //睡眠一秒钟，循环没执行一次 就会睡眠一秒钟
				 Thread.sleep(1000);//单位毫秒
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(this.getName()+"----i---"+i);
		}
	}
	
	
	

}
