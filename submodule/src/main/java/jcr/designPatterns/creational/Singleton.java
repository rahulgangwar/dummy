package jcr.designPatterns.creational;

public class Singleton {
    // volatile variable
    private static volatile Singleton _instance;

    private static Singleton getInstance() {
        System.out.println("1 - " + threadName() + " - " + _instance);
        if (_instance == null) {
            System.out.println("2 - " + threadName() + " - " + _instance);
            synchronized (Singleton.class) {
                if (_instance
                        == null) { // if we do not check here 2 threads will get different objects
                    _instance = new Singleton();
                    System.out.println("3 - " + threadName() + " - " + _instance);
                }
            }
        }
        System.out.println("4 - " + threadName() + " - " + _instance);
        return _instance;
    }

    public static void main(String[] args) {
        Thread thread1 =
                new Thread(
                        () -> System.out.println(threadName() + " - " + Singleton.getInstance()));
        Thread thread2 =
                new Thread(
                        () -> System.out.println(threadName() + " - " + Singleton.getInstance()));

        thread1.start();
        thread2.start();
    }

    private static String threadName() {
        return Thread.currentThread().getName();
    }
}
