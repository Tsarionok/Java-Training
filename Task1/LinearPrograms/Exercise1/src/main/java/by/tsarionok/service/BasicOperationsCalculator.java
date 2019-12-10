package by.tsarionok.service;

public class BasicOperationsCalculator implements Calculable {

    public double sum(double x, double y) {
        return x + y;
    }

    public double sum(double... numbers) {
        double totalSum = 0;
        for (double num : numbers) {
            totalSum = sum(totalSum, num);
        }
        return totalSum;
    }

    public double difference(double x, double y) {
        return x - y;
    }

    public double multiply(double x, double y) {
        return x * y;
    }

    public double multiply(double... numbers) {
        double totalComposition = 1;
        for (double num : numbers) {
            totalComposition = multiply(totalComposition, num);
        }
        return totalComposition;
    }

    public double division(double dividend, double divisor) {
        return dividend / divisor;
    }
}
