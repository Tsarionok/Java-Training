package by.tsarionok.service.filler.impl;

import by.tsarionok.entity.thread.ExecutorMatrixThread;
import by.tsarionok.service.filler.Variant;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class FillByExecutorVariant implements Variant {

    private static final int TIMEOUT = 100;

    @Override
    public int[][] variant(final int threadNumber, final int[] values, final int[][] array) {

        int poolLimit = array.length / threadNumber + 1;

        ExecutorService executorService = Executors.newFixedThreadPool(poolLimit);

        int[][] copy = getCopy(array);

        for (int i = 0; i < threadNumber; i++) {
            executorService.execute(new ExecutorMatrixThread(i, "ExecutorThread", copy, values));
        }

        executorService.shutdown();

        while (!executorService.isTerminated()) {
            try {
                TimeUnit.MILLISECONDS.sleep(TIMEOUT);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        return copy;
    }
}
