package by.tsarionok.controller;

import by.tsarionok.service.NaturalNumService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Runner {
    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> numbers = new ArrayList<>();

        final int N = 10;

        for (int i = 0; i < N; i++) {
            numbers.add(random.nextInt() % 30 + 30);
        }

        NaturalNumService numService = new NaturalNumService();

        System.out.println(numbers);

        System.out.println(numService.multipleNumbers(numbers, 3));
    }
}
