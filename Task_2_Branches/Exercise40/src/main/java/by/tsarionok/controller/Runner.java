package by.tsarionok.controller;

import by.tsarionok.service.FunctionCalculator;

public class Runner {
    public static void main(String[] args) {
        FunctionCalculator calculator = new FunctionCalculator();
        System.out.println(calculator.calculationResult(3));
        System.out.println(calculator.calculationResult(13));
        System.out.println(calculator.calculationResult(12));
        System.out.println(calculator.calculationResult(14.3));
        System.out.println(calculator.calculationResult(-3));

    }
}
