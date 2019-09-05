/**
 * 
 */
package org.fkjava.threadApp.取款05;

import java.util.Scanner;

/**
 * @author Long
 * Version:1.0
 * 
 * 取款，但是操作不同的账户
 */
public class MainTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//创建账户
		Account account = new Account();
		System.out.println("account:"+account);
		//这是余额
		account.setAmount(10000);
		
		
		
		
		
		//模拟小明以及小明老婆两个取钱的线程     第一个参数：取款账户信息       第二个参数：取多少钱
		DrawThread thread01 = new DrawThread(account,10000);
		//设置线程名字
		thread01.setName("小明");
		                            //第一个参数：取款账户信息       第二个参数：取多少钱
		DrawThread thread02 = new DrawThread(account,10000);
		//设置线程名字
		thread02.setName("小明老婆");
		
		
	
		
		//获取小明输入的信息，账号以及密码
		Scanner  scanner = new Scanner(System.in);
		System.out.println("[小明]请输入账号：");
		String zh = scanner.next();
		System.out.println("[小明]请输入密码：");
		String password = scanner.next();
		account.setCardId(zh);
		account.setPassword(password);
		
		
		
		//获取小明老婆输入的信息，账号以及密码
		System.out.println("[小明老婆]请输入账号：");
		String zh2 = scanner.next();
		System.out.println("[小明老婆]请输入密码：");
		String password2 = scanner.next();
		account.setCardId(zh2);
		account.setPassword(password2);
		
		
		//让两个线程就绪，准备取钱，cpu会调用thread01的run方法
		thread01.start();
		thread02.start();
		  
		

	}

}
