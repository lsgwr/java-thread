package chapter6atomic.section3Array;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * 更新数组
 */
public class AtomicIntegerArrayDemo {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 2};
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(arr);
        // 第2个(下标为1表示第二个元素)元素加上8
        System.out.println(atomicIntegerArray.addAndGet(1, 8));
        // 下标为0的元素left(这里是第一个参数)和外面输入的值right(这里是第二个参数)相乘后除以3. 即3*2/3 = 2
        int i = atomicIntegerArray.accumulateAndGet(0, 2, (left, right) ->
                left * right / 3
        );


        System.out.println(i);
    }

}
