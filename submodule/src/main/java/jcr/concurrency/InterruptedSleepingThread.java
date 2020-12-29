package jcr.concurrency;

public class InterruptedSleepingThread extends Thread {

    @Override
    public void run() {
        doAPseudoHeavyWeightJob();
    }

    private void doAPseudoHeavyWeightJob() {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            System.out.println(i + " " + i * 2);
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Thread interrupted... Exiting...");
                break;
            } else {
                sleepBabySleep();
            }
        }
    }

    private void sleepBabySleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Interrupting");

            Thread.currentThread().interrupt();

            System.out.println("Interrupted");
        }
    }
}
