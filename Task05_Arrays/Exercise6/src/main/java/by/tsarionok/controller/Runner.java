package by.tsarionok.controller;

import by.tsarionok.service.NumberLineService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Runner {
    public static void main(String[] args) {

        final int SIZE = 10;

        Random random = new Random();

        List<Double> numbers = new ArrayList<>();

        for (int i = 0; i < SIZE; i++) {
            numbers.add(random.nextDouble() * 20);
        }

        System.out.println(numbers);

        NumberLineService numberLineService = new NumberLineService(numbers);
        System.out.println(numberLineService.findMax() + " " + numberLineService.findMin());
        System.out.println(numberLineService.numberLineSize());

    }
}
