package by.tsarionok.controller;

import by.tsarionok.exception.MonthEnterException;
import by.tsarionok.service.MonthService;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter month number: ");
        try {
            System.out.println("Season is: " + new MonthService().defineSeason(scanner.nextInt()));
        } catch (MonthEnterException e) {
            e.printStackTrace();
        }
    }
}
