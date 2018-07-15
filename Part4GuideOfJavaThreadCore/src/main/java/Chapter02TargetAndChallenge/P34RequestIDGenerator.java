/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/5/22 22:39
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package Chapter02TargetAndChallenge;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class P34RequestIDGenerator implements P34CircularSeqGenerator {
    /**
     * 保存该类的唯一实例
     */
    private final static P34RequestIDGenerator INSTANCE = new P34RequestIDGenerator();
    /**
     * 顺序队列的上限值
     */
    private static short SEQ_UPPER_LIMIT = 999;

    private short sequence = -1;

    /**
     * 私有构造器，不允许外部实例化
     */
    private P34RequestIDGenerator() {
    }

    @Override
    public short nextSequence() {
        if (sequence >= SEQ_UPPER_LIMIT) {
            sequence = 0;
        } else {
            sequence++;
        }
        return sequence;
    }

    public String nextID() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
        String timestamp = sdf.format(new Date());
        DecimalFormat df = new DecimalFormat("000");
        // 生成请求
        short sequenceNO = nextSequence();
        return "0049" + timestamp + df.format(sequenceNO);
    }

    public static P34RequestIDGenerator getINSTANCE() {
        return INSTANCE;
    }
}
