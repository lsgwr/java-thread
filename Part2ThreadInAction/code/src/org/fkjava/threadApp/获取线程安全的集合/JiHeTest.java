/**
 * 
 */
package org.fkjava.threadApp.获取线程安全的集合;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * @author Long
 * Version:1.0
 */
public class JiHeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //java中提供了一个工具类  Collections，调用Collections类中指定的方法可以获取线程安全的集合
		List<Integer> list = Collections.synchronizedList(new ArrayList<Integer>());
		
		//获取线程安全的HashMap集合
		Map<Integer,String> maps = Collections.synchronizedMap(new HashMap<Integer,String>());
		
	
	}

}
