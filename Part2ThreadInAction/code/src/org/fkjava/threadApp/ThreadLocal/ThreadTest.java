/**
 * 
 */
package org.fkjava.threadApp.ThreadLocal;

/**
 * @author Long
 * Version:1.0
 * 
 * 
 */
public class ThreadTest extends Thread{
	
	private SequenceNum sequenceNum;
	
	public ThreadTest(SequenceNum sequenceNum) {
		super();
		// TODO Auto-generated constructor stub
		this.sequenceNum = sequenceNum;
	}
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 3; i++) {
			
			System.out.println("当前线程名："+this.getName()+"   ---i:"+sequenceNum.getNextNum());
			
		}
	}

	 
	   
}
