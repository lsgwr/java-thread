/**
 * 
 */
package org.fkjava.threadApp.常用方法;

/**
 * @author Long
 * Version:1.0
 * join:等待线程完成
 */
public class ThreadJoin extends Thread{

	/**
	 * 主线程 main方法
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		  ThreadJoin thread = new ThreadJoin();
		  thread.setName("线程一");
		  //让线程就绪
		  thread.start();
		  
		

		  try {
			  
			  for (int j = 0; j < 50; j++) {
				  if(j==20) {
					  //当 j 等于 20的时候，让 thread执行，知道thread线程执行完毕之后，才把机会交给其他线程
					 thread.join();
				  }
					System.out.println(Thread.currentThread().getName()+"----j---"+j);
			 }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		 
		  
	}

	//重写Thread中的run方法
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		
			 for (int i = 0; i < 50; i++) {
				System.out.println(this.getName()+"----i---"+i);
			}
		
		
	}
	
	
	

}
