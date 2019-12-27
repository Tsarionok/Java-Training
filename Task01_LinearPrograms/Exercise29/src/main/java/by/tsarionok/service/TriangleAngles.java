package by.tsarionok.service;

import by.tsarionok.entity.Triangle;
import by.tsarionok.exception.TriangleExistingException;

public class TriangleAngles implements TriangleAnalyzable {

    private final int SIDES_AMOUNT = 3;

    private Triangle triangle;

    private double[] angles;

    public TriangleAngles(Triangle triangle) {
        this.triangle = triangle;
        this.angles = new double[SIDES_AMOUNT];
    }

    public boolean isTriangle() {
        return (triangle.getA() + triangle.getB() > triangle.getC()) &&
                (triangle.getB() + triangle.getC() > triangle.getA()) &&
                (triangle.getC() + triangle.getA() > triangle.getB());
    }

    private double cosineTheoremAngle(double firstSize, double secondSize, double oppositeToAngle) {
        return Math.acos((Math.pow(firstSize, 2) + Math.pow(secondSize, 2) - Math.pow(oppositeToAngle, 2)) / (2 * firstSize * secondSize));
    }

    private void anglesBySides() {
        try {
            if (isTriangle()) {
                angles[0] = cosineTheoremAngle(triangle.getA(), triangle.getB(), triangle.getC());
                angles[1] = cosineTheoremAngle(triangle.getC(), triangle.getA(), triangle.getB());
                angles[2] = cosineTheoremAngle(triangle.getB(), triangle.getC(), triangle.getA());
            } else {
                throw new TriangleExistingException();
            }
        } catch (TriangleExistingException exception) {
            exception.printStackTrace();
        }
    }

    public double[] convertToDegrees() {
        anglesBySides();
        double[] degrees = new double[SIDES_AMOUNT];
        for (int i = 0; i < SIDES_AMOUNT; i++) {
            degrees[i] = angles[i] * 180 / Math.PI;
        }
        return degrees;
    }

    public double[] getAngles() {
        return angles;
    }
}
