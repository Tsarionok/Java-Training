package by.tsarionok.service;

import by.tsarionok.entity.Triangle;
import by.tsarionok.exception.TriangleSideException;

import static java.lang.Double.NaN;

public class TriangleAnalyzer implements TriangleAnalyzable {
    private Triangle triangle;

    public TriangleAnalyzer(Triangle triangle) {
        this.triangle = triangle;
    }

    public boolean isTriangle() {
        // Rule of existing triangle: a^2 + b^2 = c^2
        if (triangle.getFirstLegLength() < 0 || triangle.getSecondLegLength() < 0 || triangle.getHypotenuseLength() < 0) {
            return false;
        } else {
            return true;
        }
    }

    public double showSquare() {
        double triangleSquare = NaN;
        try {
            if (isTriangle()) {
                triangleSquare = triangle.getFirstLegLength() * triangle.getSecondLegLength() / 2;
            } else {
                throw new TriangleSideException();
            }
        } catch (TriangleSideException exception) {
            exception.printStackTrace();
        }
        return triangleSquare;
    }

    public double showPerimeter() {
        double trianglePerimeter = NaN;
        try {
            if (isTriangle()) {
                trianglePerimeter = triangle.getFirstLegLength()
                        + triangle.getSecondLegLength()
                        + triangle.getHypotenuseLength();
            } else {
                throw new TriangleSideException();
            }
        } catch (TriangleSideException exception) {
            exception.printStackTrace();
        }
        return trianglePerimeter;
    }
}
