package by.tsarionok.service;

import java.util.List;

public class NumberLineService {

    List<Double> numbers;

    public NumberLineService(List<Double> numbers) {
        this.numbers = numbers;
    }

    public double findMin() {
        double min = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            if (min > numbers.get(i)) {
                min = numbers.get(i);
            }
        }
        return min;
    }

    public double findMax() {
        double max = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            if (max < numbers.get(i)) {
                max = numbers.get(i);
            }
        }
        return max;
    }

    public double numberLineSize() {
        return Math.abs(findMax() - findMin());
    }
}
