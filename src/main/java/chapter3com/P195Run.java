/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 下午10:30
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3com;

public class P195Run {
    public static P195ThreadLocalExt t1 = new P195ThreadLocalExt();

    public static void main(String[] args) {
        if (t1.get()==null){
            System.out.println("还是为null哦....");
        }
        System.out.println(t1.get());
        System.out.println(t1.get());
    }
}
