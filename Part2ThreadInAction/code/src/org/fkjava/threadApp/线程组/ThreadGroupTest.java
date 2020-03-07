/**
 * 
 */
package org.fkjava.threadApp.线程组;

/**
 * @author 罗春龙
 * version:1.0
 * 线程组：可以对线程进行批量管理，包括可以用线程组处理该组中所有的线程出现的异常
 */
public class ThreadGroupTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//创建线程组
		ThreadGroup  threadGroup = new ThreadGroup("线程组一") {

			@Override
			public void uncaughtException(Thread t, Throwable e) {
				// TODO Auto-generated method stub
				//e.printStackTrace();
				System.out.println(t.getName()+"  异常的原因："+e.getMessage());
			}
			
		};
		
		
		//创建线程
		Th th1 = new Th();
		
		//创建线程  指定该线程属于哪一个线程组        第一个参数：线程组     第二个参数：Runnable实现类实例    第三个参数：线程名字
		Thread thread = new Thread(threadGroup,th1,"线程一");
		//让线程就绪
		thread.start();
		
		Thread thread2 = new Thread(threadGroup,th1,"线程二");
		thread2.start();
		
		System.out.println("====代码执行完毕===");
		
	}

}


class Th implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 20; i++) {
			if(i==10) {
				
				System.out.println(20/(i-10));

			}else {
				System.out.println("线程名："+Thread.currentThread().getName()+"    i:"+i);
			}
			 
		}
		
		System.out.println(Thread.currentThread().getName()+"执行完毕=====");
	}
	
	  
}