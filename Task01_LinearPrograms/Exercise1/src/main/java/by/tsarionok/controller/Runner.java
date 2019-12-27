package by.tsarionok.controller;

import by.tsarionok.service.BasicOperationsCalculator;

public class Runner {
    public static void main(String[] args) {
        BasicOperationsCalculator calculator = new BasicOperationsCalculator();
        System.out.println(calculator.sum(2.2, 40.23));
        System.out.println(calculator.difference(34, 2.4));
        System.out.println(calculator.multiply(23, 4.3, 12));
        System.out.println(calculator.division(32.3, 2.5));
    }
}
