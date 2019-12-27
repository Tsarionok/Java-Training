package by.tsarionok.controller;

import by.tsarionok.entity.Test1;
import by.tsarionok.service.TestService;

public class Runner {
    public static void main(String[] args) {
        TestService service = new TestService();
        Test1 test1 = new Test1(1, 4);
        System.out.print("Sum: " + test1.getA() + " + " + test1.getB() + " = ");
        System.out.print(service.calcSum(test1));

    }
}
