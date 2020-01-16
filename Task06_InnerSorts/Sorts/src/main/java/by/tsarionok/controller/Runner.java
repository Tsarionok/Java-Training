package by.tsarionok.controller;

import by.tsarionok.service.SortService;

import java.util.List;

public class Runner { // выбором, двусторонним выбором, пузырьком, шейкерная
    public static void main(String[] args) {
        List<Double> numbers;
        ReadFileController readFileController = new ReadFileController();
        numbers = readFileController.readFile("data/array.txt");

        MenuController menuController = new MenuController();

        System.out.println(numbers);

        SortService<Double> sortService = menuController.choiceSort();
        sortService.setNumbers(numbers);

        System.out.println(sortService.sort());

    }
}
