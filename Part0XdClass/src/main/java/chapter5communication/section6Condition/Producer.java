package chapter5communication.section6Condition;

/**
 * 生产者
 */
public class Producer implements Runnable{

    private Medium medium;

    public Producer(Medium medium) {
        this.medium = medium;
    }

    @Override
    public void run() {
        while (true) {
            medium.put();
        }
    }
}
