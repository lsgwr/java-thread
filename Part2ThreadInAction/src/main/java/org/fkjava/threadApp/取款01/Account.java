/**
 * 
 */
package org.fkjava.threadApp.取款01;

/**
 * @author Long
 * Version:1.0
 * 该类用于封装账号相关信息
 */
public class Account {

	 //卡号
	  private String cardId;
	
	 //密码
	  private String password;
	
	 //余额
	  private double amount;
	  
	  
	  
	  //定义取钱的方法
	  public void draw(double drawMoney) {
		  
		  //判断用户账号  密码  是否正确，如果正确继续判断 取款 是否小于余额
		  //假设账号 8888   密码1234
		  if(this.getCardId().equals("8888") &&  this.getPassword().equals("1234")) {
			  
			  //判断余额是否大于用户取款金额
			  if(this.getAmount() >= drawMoney) {
				 
				  try {
					  //让线程睡眠
					  Thread.sleep(1000);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				 
				  //更新余额
				  this.setAmount(this.getAmount() - drawMoney);
				  System.out.println(Thread.currentThread().getName()+"取款成功，卡中还有余额"+this.getAmount());
				  
			  }else {
				  System.out.println(Thread.currentThread().getName()+"取款失败，余额不足！");
			  }
			  
			  
		  }else {
			  System.out.println(Thread.currentThread().getName()+"取款失败，账号或密码输入不正确！");
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
	 * @return the amount
	 */
	public double getAmount() {
		return this.amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	} 
	  
	  
	  
	 
}
