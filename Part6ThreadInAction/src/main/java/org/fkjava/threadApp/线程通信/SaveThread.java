/**
 * 
 */
package org.fkjava.threadApp.线程通信;

/**
 * @author Long
 * Version:1.0
 * 模拟存钱线程
 */
public class SaveThread extends Thread {
    
	//存款账户
	private Account account;
	//存多少钱
	private double saveMoney;

	
	public SaveThread(Account account,double saveMoney) {
		
		this.account = account;
		this.saveMoney = saveMoney;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

         //不断给小明打钱
		while(true) {
			//给指定账户存钱
			account.saveMoney(saveMoney);
		}

	}
	
	
	   

}
