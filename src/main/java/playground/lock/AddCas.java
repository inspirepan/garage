package playground.lock;

import java.util.concurrent.atomic.AtomicInteger;

public class AddCas {
    static AtomicInteger i = new AtomicInteger(0);

    private static void add() {
        i.incrementAndGet();
    }

    private static class Plus implements Runnable {
        @Override
        public void run() {
            for (int k = 0; k < 10000000; k++) {
                add();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new Plus());
            threads[i].start();
        }

        for (int i = 0; i < 10; i++) {
            threads[i].join();
        }
        System.out.println(i);
    }
}
