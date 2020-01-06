package by.tsarionok.service.impl;

import by.tsarionok.service.SortService;

import java.util.List;
import java.util.Objects;

public class InsertSortServiceImpl<T extends Number> implements SortService {

    List<T> numbers;

    public InsertSortServiceImpl() {
    }

    public InsertSortServiceImpl(List<T> numbers) {
        this.numbers = numbers;
    }

    /**
     * sort ascending
     */
    @Override
    public List sort() {
        int j;
        T number;
        /**
         *
         * starts with remember 1 (second) element of list
         * and compare it with 0 (first)
         *
         */
        for (int i = 1; i < numbers.size(); i++) {
            j = i - 1;
            number = numbers.get(i);
            if (number.doubleValue() > numbers.get(j).doubleValue()) {
                continue;
            }
            // double value is norm???
            while (j >= 0 && number.doubleValue() < numbers.get(j).doubleValue()) {
                numbers.set(j + 1, numbers.get(j));
                j--;
            }
            numbers.set(j + 1, number);
        }
        return numbers;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    public List<T> getNumbers() {
        return numbers;
    }

    public void setNumbers(List numbers) {
        this.numbers = numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InsertSortServiceImpl<?> that = (InsertSortServiceImpl<?>) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
