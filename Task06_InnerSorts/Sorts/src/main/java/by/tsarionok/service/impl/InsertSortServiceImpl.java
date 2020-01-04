package by.tsarionok.service.impl;

import by.tsarionok.service.SortService;

import java.util.List;

public class InsertSortServiceImpl<T extends Number> implements SortService {

    List<T> numbers;

    public InsertSortServiceImpl(List<T> numbers) {
        this.numbers = numbers;
    }

    /**
     * sort ascending
     */
    @Override
    public List<T> sort() {
        int j;
        /**
         *
         * starts with remember 1 (second) element of list
         * and compare it with 0 (first)
         *
         */
        for (int i = 1; i < numbers.size(); i++) {
            j = i - 1;
            T number = numbers.get(i);
            if (number.doubleValue() > numbers.get(j).doubleValue()) {
                continue;
            }
            // double value is norm???
            while (number.doubleValue() > numbers.get(j).doubleValue() && j > 0) {
                numbers.set(j + 1, numbers.get(j));
                j--;
            }
            numbers.set(j, number);
        }
        return numbers;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
