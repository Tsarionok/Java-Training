package by.tsarionok.service;

import java.util.ArrayList;
import java.util.List;

public class ArrayService {

    public double findMax(List<Double> numbers) {
        List<Double> converts = convert(numbers);
        double max = converts.get(0);
        for (int i = 0; i < converts.size(); i++) {
            if (max < converts.get(i)) {
                max = converts.get(i);
            }
        }
        return max;
    }

    public List<Double> convert(List<Double> numbers) {
        List<Double> converts = new ArrayList<>();
        for (int i = 0; i < numbers.size() / 2; i++) {
            if (numbers.size() % 2 == 0 && i == numbers.size() / 2) {
                converts.add(numbers.get(i));
                break;
            }
            converts.add(numbers.get(i) + numbers.get(numbers.size() - 1 - i));
        }
        return converts;
    }
}
