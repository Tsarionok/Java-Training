package by.tsarionok.controller;

import by.tsarionok.service.ArraySumService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Runner {
    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(random.nextInt() % 20);
        }

        System.out.println(list);

        ArraySumService<Integer> sumService = new ArraySumService<>(list);

        System.out.println(sumService.sumElements(2, 1));
    }
}
