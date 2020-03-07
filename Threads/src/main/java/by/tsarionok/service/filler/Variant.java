package by.tsarionok.service.filler;

import java.util.Arrays;

public interface Variant {

    int[][] variant(int threadNumber, int[] values, int[][] array);

    default int[][] getCopy(int[][] array) {
        return Arrays.stream(array)
                .map(r -> Arrays.copyOf(r, r.length))
                .toArray(int[][]::new);
    }
}
