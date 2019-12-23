package by.tsarionok.service;

import java.util.ArrayList;
import java.util.List;

public class NaturalNumService {

    public boolean isMultiple(int dividend, int divisor) throws ArithmeticException {
        if (divisor == 0) {
            throw new ArithmeticException();
        }
        if (dividend % divisor == 0) {
            return true;
        }
        return false;
    }

    public List<Integer> multipleNumbers(List<Integer> numbers, int divisor) {
        List<Integer> multiples = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            if (isMultiple(numbers.get(i), divisor)) {
                multiples.add(numbers.get(i));
            }
        }
        return multiples;
    }
}
