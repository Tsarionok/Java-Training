package by.tsarionok.service.impl;

import by.tsarionok.service.SortService;

import java.util.List;

public class InsertSortServiceImpl<T extends Number> implements SortService {

    List<T> numbers;

    public InsertSortServiceImpl() {
    }

    public InsertSortServiceImpl(List<T> numbers) {
        this.numbers = numbers;
    }

    @Override
    public List sort() {
        int j;
        T number;

        for (int i = 1; i < numbers.size(); i++) {
            j = i - 1;
            number = numbers.get(i);
            if (number.doubleValue() > numbers.get(j).doubleValue()) {
                continue;
            }

            while (j >= 0 && number.doubleValue() < numbers.get(j).doubleValue()) {
                numbers.set(j + 1, numbers.get(j));
                j--;
            }
            numbers.set(j + 1, number);
        }
        return numbers;
    }

    public List<T> getNumbers() {
        return numbers;
    }

    public void setNumbers(List numbers) {
        this.numbers = numbers;
    }

}
