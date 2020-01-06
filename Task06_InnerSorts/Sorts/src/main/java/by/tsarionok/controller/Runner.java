package by.tsarionok.controller;

import by.tsarionok.service.SortService;
import by.tsarionok.service.impl.InsertSortServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Runner { // выбором, двусторонним выбором, пузырьком, шейкерная
    public static void main(String[] args) {

        final int SIZE = 30;

        Random random = new Random();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            numbers.add(random.nextInt() % 15 + 15);
        }

        System.out.println(numbers);

        SortService<Integer> sortService = new InsertSortServiceImpl<>(numbers);

        System.out.println(sortService.sort());

    }
}
