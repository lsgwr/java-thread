/***********************************************************
 * @Description : Map内存锁
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/7/15 11:58
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package Chapter01Start;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@Slf4j
public class MapExample {
    private static int threadNum = 200;
    private static int clientNum = 5000;
    private static Map<Integer, Integer> map = Maps.newHashMap();

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadNum);
        for (int i = 0; i < clientNum; i++) {
            final int threadNum = i;
            exec.execute(() -> {
                try {
                    semaphore.acquire();
                    func(threadNum);
                    semaphore.release();
                } catch (InterruptedException e) {
                    log.error("exception", e);
                }
            });
        }
        exec.shutdown();
        log.info("size:{}", map.size());
    }

    private static void func(int threadNum) {
        map.put(threadNum, threadNum);
    }
}
