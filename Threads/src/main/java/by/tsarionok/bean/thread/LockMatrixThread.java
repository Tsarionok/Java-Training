package by.tsarionok.bean.thread;

import by.tsarionok.bean.BasicThread;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class LockMatrixThread extends BasicThread implements Runnable {

    private static final Logger LOGGER =
            LogManager.getLogger(LockMatrixThread.class);

    private static final int TIMEOUT = 30;

    private Lock lock;

    public LockMatrixThread(final int idValue, final String nameValue,
                            final int[][] arrayValue, final int[] diagValues,
                            final Lock lockValue) {
        super(idValue, nameValue, arrayValue, diagValues);
        lock = lockValue;
    }

    @Override
    public void run() {
        for (int i = getId(); i < getArray().length; i++) {
            //find first empty diagonal value
            if (getArray()[i][i] == 0) {
                try {
                    //trying to acquire the lock
                    boolean flag = lock.tryLock(TIMEOUT, TimeUnit.MILLISECONDS);
                    if (flag) {
                        try {
                            //check if the value is still empty
                            if (getArray()[i][i] == 0) {
                                //set new value
                                getArray()[i][i] = getValues()[getId()];
                                String message = String.format(
                                        "%s has insert %d at %d position",
                                        getName(), getValues()[getId()], i);
                                LOGGER.debug(message);
                            }
                        } finally {
                            lock.unlock();
                        }
                        TimeUnit.MILLISECONDS.sleep(TIMEOUT);
                    }
                } catch (InterruptedException e) {
                    String errorMessage = String.format("%s was interrupted",
                            getName());
                    LOGGER.error(errorMessage);
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
