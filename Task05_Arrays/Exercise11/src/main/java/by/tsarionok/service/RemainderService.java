package by.tsarionok.service;

import java.util.ArrayList;
import java.util.List;

public class RemainderService {

    public List<Integer> remindDivision(List<Integer> numbers, int divisor, int reminder) {
        List<Integer> reminders = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) % divisor == reminder) {
                reminders.add(numbers.get(i));
            }
        }

        return reminders;
    }
}
