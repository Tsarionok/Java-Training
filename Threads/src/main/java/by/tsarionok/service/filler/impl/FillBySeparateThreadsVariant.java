package by.tsarionok.service.filler.impl;

import by.tsarionok.entity.thread.SimpleMatrixThread;
import by.tsarionok.service.filler.Variant;

public class FillBySeparateThreadsVariant implements Variant {

    @Override
    public int[][] variant(final int threadNumber, final int[] values, final int[][] array) {

        int[][] copy = getCopy(array);

        int count = array.length / threadNumber;
        int additional = array.length % threadNumber;

        Thread[] threads = new Thread[threadNumber];

        int start = 0;
        for (int i = 0; i < threads.length; i++) {
            int currentCount;
            if (i == 0) {
                currentCount = count + additional;
            } else {
                currentCount = count;
            }
            int end = start + currentCount - 1;
            threads[i] = new Thread(new SimpleMatrixThread(i, "IndexThread", copy, values, start, end));
            start = start + currentCount;
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
