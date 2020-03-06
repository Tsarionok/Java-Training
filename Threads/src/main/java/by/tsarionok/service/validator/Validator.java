package by.tsarionok.service.validator;

import java.util.List;

public class Validator {

    private static final int MIN_THREADS = 4;

    private static final int MAX_THREADS = 6;

    private static final int MIN_DIM = 8;

    private static final int MAX_DIM = 12;

    public boolean isValidValue(final String value) {
        return value != null && !value.isEmpty();
    }

    public boolean isNumber(final String value) {
        if (isValidValue(value)) {
            try {
                Integer.parseInt(value);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean isSquareMatrix(final List<String> list,
                                  final String delimiter) {

        int verticalSize = list.size();
        int horizontalSize = list.get(0).split(delimiter).length;

        for (String s : list) {
            String[] row = s.split(delimiter);
            if (row.length != verticalSize) {
                return false;
            }
        }
        return verticalSize == horizontalSize;
    }

    public boolean isValidThreadNumber(final int threadNum) {
        return threadNum >= MIN_THREADS && threadNum <= MAX_THREADS;
    }

    public boolean isValidDiagValues(final int[] diagValue,
                                     final int threadNumber) {
        return threadNumber != diagValue.length;
    }

    public boolean isValidDimension(final int n) {
        return n >= MIN_DIM && n <= MAX_DIM;
    }

    public boolean isValidDiagonalValue(final String value) {
        if (isNumber(value)) {
            return Integer.parseInt(value) != 0;
        } else {
            return false;
        }
    }
}
