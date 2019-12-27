package by.tsarionok.service;

import by.tsarionok.exception.ArrayIndexesException;

import java.util.List;

public class ArraySumService<T extends Number> {
    private List<T> array;

    public ArraySumService(List<T> array) {
        this.array = array;
    }

    private boolean isArrayPart(final int from, final int until) {
        if (from < 0 || from > array.size() ||
                until < 0 || until > array.size()) {
            return false;
        } else return from <= until;
    }

    public T sumElements(final int from, final int until) throws ArrayIndexesException {
        if (isArrayPart(from, until)) {
            Double doubleSum = 0.d;
            for (int i = from; i <= until; i++) {
                doubleSum += array.get(i).doubleValue();
            }
            return (T) doubleSum;
        } else {
            throw new ArrayIndexesException("\'from\': " + from + " must be less or equal than \'until\': " + until);
        }
    }
}
