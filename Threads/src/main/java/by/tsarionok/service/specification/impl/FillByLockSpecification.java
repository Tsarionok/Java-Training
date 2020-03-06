package by.tsarionok.service.specification.impl;

import by.tsarionok.bean.thread.LockMatrixThread;
import by.tsarionok.service.specification.Specification;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FillByLockSpecification implements Specification {

    @Override
    public int[][] specified(final int threadNumber, final int[] values,
                             final int[][] array) {

        int[][] copy = getCopy(array);

        Lock lock = new ReentrantLock(true);

        Thread[] threads = new Thread[threadNumber];

        for (int i = 0; i < threadNumber; i++) {
            threads[i] = new Thread(
                    new LockMatrixThread(i, "LockThread", copy, values, lock));
            threads[i].start();
        }

        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return copy;
    }
}
