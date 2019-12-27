package by.tsarionok.controller;

import by.tsarionok.service.FuncCalculator;

public class Runner {
    public static void main(String[] args) {
        FuncCalculator calculator = new FuncCalculator();
        double result = calculator.calculate(2);
        System.out.println(result);
    }
}
