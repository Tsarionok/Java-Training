package by.tsarionok.service;

public class FunctionCalculator {
    public double calculationResult(double x) {
        if (x > 13) {
            return -3 / (x + 1);
        } else {
            return -(x * x * x) + 9;
        }
    }
}
