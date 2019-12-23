package by.tsarionok.controller;

import by.tsarionok.service.RemainderService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Runner {
    public static void main(String[] args) {

        final int SIZE = 30;

        Random random = new Random();

        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < SIZE; i++) {
            numbers.add(random.nextInt() % 50 + 50);
        }

        System.out.println(numbers);

        RemainderService remainderService = new RemainderService();

        System.out.println(remainderService.remindDivision(numbers, 3, 2));


    }
}
