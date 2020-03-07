/**
 * 
 */
package org.fkjava.threadApp.线程通信;

/**
 * @author Long
 * Version:1.0
 * 模拟取钱线程
 */
public class DrawThread extends Thread {

	
	//存款账户
	private Account account;
	//存款金额
	private double quKuanMoney;

	
	public DrawThread(Account account,double quKuanMoney) {
		
		this.account = account;
		this.quKuanMoney = quKuanMoney;
	}
	
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			//开始取钱
			account.drawMoney(quKuanMoney);
		}
	}
}
