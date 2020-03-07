package by.tsarionok.entity.thread;

import by.tsarionok.entity.BasicThread;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class ExecutorMatrixThread extends BasicThread implements Runnable {

    private static final Logger LOGGER = LogManager.getLogger(
            ExecutorMatrixThread.class);

    private static AtomicInteger startRange = new AtomicInteger(0);

    private int start;

    private int end;

    public ExecutorMatrixThread(final int idValue, final String nameValue, final int[][] arrayValue, final int[] diagValues) {
        super(idValue, nameValue, arrayValue, diagValues);
        perform();
    }

    @Override
    public void run() {
        IntStream.rangeClosed(start, end)
                .filter(i -> getArray()[i][i] == 0)
                .forEach(i -> {
                    getArray()[i][i] = getValues()[getId()];
                    String message =
                            String.format("%s has insert %d at %d position",
                                    getName(), getValues()[getId()], i);
                    LOGGER.debug(message);
                });
    }

    private void perform() {
        int count = getArray().length / getValues().length;
        int additional = getArray().length % getValues().length;

        if (getId() == 0) {
            start = 0;
            end = count + additional - 1;
        } else {
            start = startRange.get();
            end = start + count - 1;
        }
        startRange.set(end + 1);
    }
}
