package com.xdclass.thread;

import com.xdclass.busi.QryBusi;
import com.xdclass.consts.DataStutusConst;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 生产者
 */
public class Producer implements Runnable {

    private static final Logger LOGGER = LoggerFactory.getLogger(Producer.class);

    private QryBusi qryBusi;
    private LinkedBlockingQueue<Runnable> consumers;
    private ThreadPoolExecutor executor;

    public Producer(QryBusi qryBusi,LinkedBlockingQueue<Runnable> consumers,ThreadPoolExecutor executor) {
        this.qryBusi = qryBusi;
        this.consumers = consumers;
        this.executor = executor;
    }

    @Override
    public void run() {
        while (true) {
            List list = qryBusi.queryList(10);
            try {
                if (list != null && list.size() > 0) {
                    //先将数据修改为处理中
                    qryBusi.modifyListStatus(list,DataStutusConst.DEALING);
                    Consumer consumer = (Consumer) consumers.take();
                    consumer.setData(list);
                    executor.execute(consumer);
                } else {
                    try {
                        Thread.sleep(5000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e) {
                LOGGER.error("生产者发生异常=======》",e);
                qryBusi.modifyListStatus(list, DataStutusConst.ERROR);
            }

        }
    }
}
