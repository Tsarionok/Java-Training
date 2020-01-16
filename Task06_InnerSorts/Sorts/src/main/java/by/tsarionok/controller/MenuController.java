package by.tsarionok.controller;

import by.tsarionok.service.SortService;
import by.tsarionok.service.impl.BubbleSortServiceImpl;
import by.tsarionok.service.impl.InsertSortServiceImpl;

import java.util.Scanner;

public class MenuController {


    public void showMenu() {

        System.out.println("Choose how to sort:");

        System.out.println("1) Bubble sort;\n" +
                "2) Insertion sort;");

    }

    public int enterChoice() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public SortService choiceSort() {
        showMenu();
        switch (enterChoice()) {
            case 1:
                return new BubbleSortServiceImpl();
            case 2:
                return new InsertSortServiceImpl();
            default:
                System.out.println("Incorrect input! Try again!");
                choiceSort();
        }
        return null;
    }
}
