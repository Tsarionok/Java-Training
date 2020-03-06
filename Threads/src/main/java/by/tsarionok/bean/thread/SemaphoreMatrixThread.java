package by.tsarionok.bean.thread;

import by.tsarionok.bean.BasicThread;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.Semaphore;

public class SemaphoreMatrixThread extends BasicThread implements Runnable {

    private static final Logger LOGGER = LogManager.getLogger(
            SemaphoreMatrixThread.class);

    private Semaphore semaphore;

    public SemaphoreMatrixThread(final int idValue, final String nameValue,
                                 final int[][] arrayValue, final int[] diagValues,
                                 final Semaphore semaphoreValue) {
        super(idValue, nameValue, arrayValue, diagValues);
        semaphore = semaphoreValue;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            for (int i = 0; i < getArray().length; i++) {
                if (getArray()[i][i] == 0) {
                    getArray()[i][i] = getValues()[getId()];
                    String message = String.format(
                            "%s has insert %d at %d position.  Available "
                                    + "permits: %d",
                            getName(), getValues()[getId()], i,
                            semaphore.availablePermits());
                    LOGGER.debug(message);
                    break;
                }
            }
            semaphore.release();
        } catch (InterruptedException e) {
            String errorMessage = String.format("%s was interrupted",
                    getName());
            LOGGER.error(errorMessage);
            Thread.currentThread().interrupt();
        }
    }
}
