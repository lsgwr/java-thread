/**
 * 
 */
package org.fkjava.threadApp.线程通信;

/**
 * @author Long
 * Version:1.0
 */
public class Account {

	  //卡号
	  private String cardId;
	  //密码
	  private String password;
	  //余额
	  private double balance;
	  
	  
	  //定义标识符  ，用于记录卡里是否有钱
	 private boolean flag = true;
	  
	  
	  //取钱
	  public synchronized void drawMoney(double quKuanMoney) {
		 
		 try {
			 if(flag) {
				 
				 if(this.getBalance() >= quKuanMoney) {
					 
					 
					 //更新余额
					 this.setBalance(this.getBalance() - quKuanMoney);
					 System.out.println(Thread.currentThread().getName()+" 取款成功，余额"+this.getBalance());
					 
					 //声明卡中没钱了
					 flag = false;
					 //通知其他线程
					  this.notifyAll();
					  //当前线程处于等待状态
					  this.wait();
					 
				 }else {
					 //余额不够
					 System.out.println(Thread.currentThread().getName()+" 取款失败，余额不够！");
					 //通知其他线程
					  this.notifyAll();
					  //当前线程处于等待状态
					  this.wait();
				 }
				   
				   
			   }else {
				   //说明没钱，通过 小头爸爸  二叔  王叔，给小明打钱
				   //通知其他线程
				   this.notifyAll();
				   //当前线程处于等待状态
				   this.wait();
			   }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		   
		  
		  
	  }
	  
	  
	  //存钱
	  public synchronized void saveMoney(double saveMoney) {
		
		  try {
			  
			  //睡眠一秒钟
			  Thread.sleep(1000);

			  if(flag) {
				  //卡里有钱，通知小明取钱
				  //通知其他线程
				   this.notifyAll();
				   //当前线程处于等待状态
				   this.wait();  
			  }else {
				  //卡里没钱，直接更新卡中余额
				  this.setBalance(this.getBalance() + saveMoney);
				  
				  System.out.println(Thread.currentThread().getName()+" 存款成功，余额"+this.getBalance());
				  //将标志位改成 true，相当于声明卡中有钱
				  flag = true;
				  
				  //通知其他线程，包括小明
				   this.notifyAll();
				   //当前线程处于等待状态
				   this.wait();  
				  
			  }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		  
		
		 

	  }


	/**
	 * @return the cardId
	 */
	public String getCardId() {
		return cardId;
	}


	/**
	 * @param cardId the cardId to set
	 */
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}


	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}


	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}


	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}


	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}
	  
	  
	  
	  
	  
}
