package by.tsarionok.service.impl;

import by.tsarionok.service.SortService;

import java.util.List;

public class BubbleSortServiceImpl<T extends Number> implements SortService {

    List<T> numbers;

    public BubbleSortServiceImpl() {
    }

    public BubbleSortServiceImpl(List<T> numbers) {
        this.numbers = numbers;
    }

    @Override
    public List sort() {
        T number;

        int i = numbers.size();

        while (i >= 0) {
            for (int j = 0; j < i - 1; j++) {
                if (numbers.get(j).doubleValue() > numbers.get(j + 1).doubleValue()) {
                    number = numbers.get(j);
                    numbers.set(j, numbers.get(j + 1));
                    numbers.set(j + 1, number);
                }
            }
            i--;
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
