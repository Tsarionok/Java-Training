package by.tsarionok.controller;

import by.tsarionok.service.InsertSortService;

import java.util.ArrayList;
import java.util.Random;

public class Runner { // выбором, двусторонним выбором, пузырьком, шейкерная
    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        InsertSortService sortService = new InsertSortService();
        for (int i = 0; i < 20; i++) {
            list.add(random.nextInt() % 20);
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("-------------");
        sortService.sort(list);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }
}
