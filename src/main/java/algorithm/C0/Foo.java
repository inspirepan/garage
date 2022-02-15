package algorithm.C0;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * S1114
 */
class Foo {

    private final ReentrantLock lock = new ReentrantLock();
    private final Condition cond = lock.newCondition();
    private int count = 1;

    public Foo() {
    }

    public void first(Runnable printFirst) throws InterruptedException {

        lock.lock();
        try {
            printFirst.run();
            count = 2;
            cond.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        lock.lock();
        try {
            while (count != 2) {
                cond.await();
            }
            printSecond.run();
            count = 3;
            cond.signal();

        } finally {
            lock.unlock();
        }

    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.

        lock.lock();
        try {
            while (count != 3) {
                cond.await();
            }
            printThird.run();
            cond.signalAll();

        } finally {
            lock.unlock();
        }

    }
}