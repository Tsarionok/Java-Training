package by.tsarionok.service.specification;

import java.util.Arrays;

public interface Specification {

    int[][] specified(int threadNumber, int[] values, int[][] array);

    default int[][] getCopy(int[][] array) {
        return Arrays.stream(array)
                .map(r -> Arrays.copyOf(r, r.length))
                .toArray(int[][]::new);
    }
}
