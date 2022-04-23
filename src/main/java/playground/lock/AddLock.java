package playground.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AddLock {

    static int i = 0;
    private static Lock lock = new ReentrantLock();

    private static void add() {
        lock.lock();
        i++;
        lock.unlock();
    }

    private static class Plus implements Runnable {
        @Override
        public void run() {
            for (int k = 0; k < 1000; k++) {
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