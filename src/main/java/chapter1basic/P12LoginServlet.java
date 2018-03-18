/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/3/18 下午6:03
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter1basic;

public class P12LoginServlet {
    private static String usernameRef;
    private static String passwordRef;

    /**
     * synchronized一定记得要加，否则username和password会串地
     */
    synchronized public static void doPost(String username, String password) {
        try {
            usernameRef = username;
            if (username.equals("a")) {
                Thread.sleep(5000);
            }
            passwordRef = password;
            System.out.println("username = " + usernameRef + ", password = " + passwordRef);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
