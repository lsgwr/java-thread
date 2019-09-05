/**
 * 
 */
package org.fkjava.threadApp.取款03;

/**
 * @author Long
 * Version:1.0
 * 
 * 模拟线程
 * 通过创建DrawThread 2个实例  模拟小明  和  小明老婆  两个线程
 * 
 */
public class DrawThread extends Thread {

	//定义账户信息
	private Account account;
	//定义取款金额
	private double drawMoney;
	
	
	
	public DrawThread(Account account,double drawMoney) {
		// TODO Auto-generated constructor stub
		this.account = account;
		this.drawMoney = drawMoney;
	}

	
	//重写Thread类的run方法，
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//调用draw方法进行取钱
		account.draw(drawMoney);
	}

	
	    
}
