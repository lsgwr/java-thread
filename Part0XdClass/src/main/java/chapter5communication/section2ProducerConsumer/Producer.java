package chapter5communication.section2ProducerConsumer;

public class Producer implements Runnable {

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
