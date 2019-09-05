/**
 * 
 */
package org.fkjava.threadApp.线程通信;

/**
 * @author Long
 * Version:1.0
 * 
 *  启动线程进行存款以及取款操作：
 *  1、小明负责取钱
 *  2、小明老爸、小明二叔、隔壁王叔   负责给小明账户存钱
 *  3、当小明的取款金额大于余额就可以取钱，当余额不够就通知其他线程给小明账户存钱
 *     存完钱之后就通知小明去取钱
 *  那么需要用到
 *  wait方法 以及  notify、notifyAll进行线程通信
 */
public class ThreadTest {

	  public static void main(String[] args) {
		
		  //创建账户
		  Account account = new Account();
		  //卡号
		  account.setCardId("88888");
		  //密码
		  account.setPassword("1234");
		  //设置余额
		  account.setBalance(10000);
		  
		   
		  //模拟四个线程    一个负责取钱   三个负责存钱      第一个参数：账户     第二个参数：取款金额
		  DrawThread drawThread = new DrawThread(account,10000);
		  drawThread.setName("大头儿子");
		  //让线程就绪
		  drawThread.start();
		  
		  //             第一个参数：账户     第二个参数：存款金额
		  SaveThread saveThread01 = new SaveThread(account,10000);
		  saveThread01.setName("小头爸爸");
		  //             第一个参数：账户     第二个参数：存款金额
		  SaveThread saveThread02 = new SaveThread(account,10000);
		  saveThread02.setName("二叔");
		  //             第一个参数：账户     第二个参数：存款金额
		  SaveThread saveThread03 = new SaveThread(account,10000);
		  saveThread03.setName("隔壁老王");
		  
		  
		  //让线程就绪
		  saveThread01.start();
		  saveThread02.start();
		  saveThread03.start();
		  
		  
	}
	  
}
