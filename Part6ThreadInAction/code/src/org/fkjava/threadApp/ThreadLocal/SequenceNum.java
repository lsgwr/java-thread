/**
 * 
 */
package org.fkjava.threadApp.ThreadLocal;

/**
 * @author Long
 * Version:1.0
 */
public class SequenceNum {

	/*
	 * 通过ThreadLocal让每个线程操作自己独立的副本，在没有使用ThreadLocal的时候，三个线程都在操作同一份资源（i）
	 * 如果希望让三个线程操作各自的副本，类似克隆 3个i出来，可以通过java提供的类ThreadLocal来实现
	 * */
	
	ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();
	
	//定义静态成员变量
	static Integer i;
	
	//定义实例方法，每次调用该实例方法  i的值都会自增
	public Integer getNextNum() {

		//从 ThreadLocal 中 获取每个线程各自的副本
		 i = threadLocal.get();
		 if(i == null) {
			 i = 0;
		 }
		
		
		//i自增
		i++;
		
		//将i的值存放在   threadLocal  中
		threadLocal.set(i);

		return i;
	}
	
 
	public static void main(String[] args) {
		
		//创建SequenceNum实例
		SequenceNum sequenceNum = new SequenceNum();
		
		
		//模拟多个线程
		ThreadTest threadTest01 = new ThreadTest(sequenceNum);
		threadTest01.setName("线程1");
		
		ThreadTest threadTest02 = new ThreadTest(sequenceNum);
		threadTest02.setName("线程2");
		
		ThreadTest threadTest03 = new ThreadTest(sequenceNum);
		threadTest03.setName("线程3");
		
		
		//让3个线程就绪
		threadTest01.start();
		threadTest02.start();
		threadTest03.start();
	}
}
