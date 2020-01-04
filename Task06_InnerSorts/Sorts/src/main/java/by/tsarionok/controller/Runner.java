package by.tsarionok.controller;

import by.tsarionok.service.SortService;
import by.tsarionok.service.impl.InsertSortServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Runner { // выбором, двусторонним выбором, пузырьком, шейкерная
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        SortService<Integer> sortService = new InsertSortServiceImpl<>(numbers);

    }
}
