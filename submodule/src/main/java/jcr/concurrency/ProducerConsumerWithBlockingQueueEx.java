package jcr.concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerWithBlockingQueueEx {
    private BlockingQueue<Integer> sharedQueue = new LinkedBlockingQueue<>();

    private class Producer extends Thread {
        Producer() {
            super("PRODUCER");
        }

        public void run() { // no synchronization needed
            for (int i = 0; i < 10; i++) {
                try {
                    System.out.println(getName() + " produced " + i);
                    sharedQueue.put(i);
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private class Consumer extends Thread {
        Consumer() {
            super("CONSUMER");
        }

        public void run() {
            try {
                while (true) {
                    Integer item = sharedQueue.take();
                    System.out.println(getName() + " consumed " + item);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new ProducerConsumerWithBlockingQueueEx().testThings();
    }

    private void testThings() {
        new Producer().start();
        new Consumer().start();
    }
}
