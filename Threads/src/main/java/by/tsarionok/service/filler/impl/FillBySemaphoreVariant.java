package by.tsarionok.service.filler.impl;

import by.tsarionok.entity.thread.SemaphoreMatrixThread;
import by.tsarionok.service.filler.Variant;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class FillBySemaphoreVariant implements Variant {

    private static final int TIMEOUT = 500;

    @Override
    public int[][] variant(final int threadNumber, final int[] values,
                           final int[][] array) {

        int permitNumber = array.length / threadNumber + 1;
        Semaphore semaphore = new Semaphore(permitNumber, true);

        int[][] copy = getCopy(array);

        int currentID = 0;
        for (int i = 0; i < copy.length; i++) {
            currentID++;
            if (currentID == threadNumber) {
                currentID = 0;
            }
            new Thread(new SemaphoreMatrixThread(currentID, "SemaphoreThread", copy, values, semaphore)).start();
        }

        try {
            TimeUnit.MILLISECONDS.sleep(TIMEOUT);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return copy;
    }
}
