/***********************************************************
 * @Description : JIT指令重排序的Demo
 * @author      : 梁山广(Liang Shan Guang)
 * @date        : 2020/3/7 17:10
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package C02多线程编程的目标与挑战;

import util.stf.Actor;
import util.stf.ConcurrencyTest;
import util.stf.TestRunner;

@ConcurrencyTest(iterations = 200000)
public class P58JITReorderingDemo {
    static class Helper {
        int payloadA;
        int payloadB;
        int payloadC;
        int payloadD;

        public Helper(int externalData) {
            this.payloadA = externalData;
            this.payloadB = externalData;
            this.payloadC = externalData;
            this.payloadD = externalData;
        }
    }

    private int externalData = 1;
    private Helper helper;

    @Actor
    public void createHelper() {
        helper = new Helper(externalData);
    }

    public int consume() {
        int sum = 0;
        // 由于我们未对共享变量helper进行任何处理(比如采用volatile关键字修饰该变量)，
        // 因此，这里可能存在可见性问题，即当前线程读取到的变量值可能为null
        final Helper observerHelper = helper;

        if (observerHelper == null) {
            sum = -1;
        } else {
            sum = observerHelper.payloadA + observerHelper.payloadB + observerHelper.payloadC + observerHelper.payloadD;
        }
        return sum;
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        TestRunner.runTest(P58JITReorderingDemo.class);
    }
}
