/***********************************************************
 * @Description : 锁非this对象，对this对象地多个synchronized方法
 *                或者代码块来说是异步执行地，大大提高了执行效率
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/6 上午11:09
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter2sync.firsthalf;

public class P83Service {
    private String usernameParam;
    private String passwordParam;


    public void setUsernameAndPassword(String username, String password) {
        try {
            // 只有一个实例
            String anyString = new String();
            // 锁定非this对象，多个synchronized方法可以异步执行
            synchronized (anyString) {
                System.out.println("线程名称为：" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "进入代码块");
                usernameParam = username;
                Thread.sleep(3000);
                passwordParam = password;
                System.out.println("线程名称为：" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "离开代码块");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
