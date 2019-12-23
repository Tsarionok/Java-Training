package by.tsarionok.controller;

import by.tsarionok.service.ArrayService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Runner {
    public static void main(String[] args) {
        Random random = new Random();

        List<Double> numbers = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            numbers.add(random.nextDouble() * 20);
        }

        System.out.println(numbers);

        ArrayService service = new ArrayService();

        System.out.println(service.findMax(numbers));
    }
}
