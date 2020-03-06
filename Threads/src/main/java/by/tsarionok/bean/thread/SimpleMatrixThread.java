package by.tsarionok.bean.thread;

import by.tsarionok.bean.BasicThread;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SimpleMatrixThread extends BasicThread implements Runnable {

    private static final Logger LOGGER = LogManager.getLogger(
            SimpleMatrixThread.class);

    private int start;

    private int end;

    public SimpleMatrixThread(final int idValue, final String nameValue,
                              final int[][] arrayValue, final int[] diagValues,
                              final int startValue, final int endValue) {
        super(idValue, nameValue, arrayValue, diagValues);
        start = startValue;
        end = endValue;
    }

    @Override
    public void run() {
        for (int i = start; i <= end; i++) {
            if (getArray()[i][i] == 0) {
                getArray()[i][i] = getValues()[getId()];
                String message = String.format(
                        "%s has insert %d at %d position.", getName(),
                        getValues()[getId()], i);
                LOGGER.debug(message);
            }
        }
    }
}
