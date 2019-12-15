package by.tsarionok.service;

import by.tsarionok.entity.Triangle;
import by.tsarionok.exception.TriangleException;

public class TrianglesAnalyzer {

    public boolean isTriangle(Triangle triangle) {
        if (triangle.getFirstSide() <= 0 && triangle.getSecondSide() <= 0 && triangle.getThirdSide() <= 0) {
            return false;
        }
        if (triangle.getFirstSide() + triangle.getSecondSide() > triangle.getThirdSide() &&
                triangle.getSecondSide() + triangle.getThirdSide() > triangle.getFirstSide() &&
                triangle.getFirstSide() + triangle.getThirdSide() > triangle.getSecondSide()) {
            return true;
        } else {
            return false;
        }
    }

    public double triangleSquare(Triangle triangle) throws TriangleException {
        if (isTriangle(triangle)) {
            double halfPerimeter = (triangle.getFirstSide() + triangle.getSecondSide() + triangle.getThirdSide()) / 2;
            return Math.sqrt(halfPerimeter * (halfPerimeter - triangle.getFirstSide()) *
                    (halfPerimeter - triangle.getSecondSide()) * (halfPerimeter - triangle.getThirdSide()));
        } else {
            throw new TriangleException();
        }
    }

    public void showGreatest(Triangle firstTriangle, Triangle secondTriangle) {
        double firstTriangleSquare = 0;
        double secondTriangleSquare = 0;
        try {
            firstTriangleSquare = triangleSquare(firstTriangle);
            secondTriangleSquare = triangleSquare(secondTriangle);
        } catch (TriangleException e) {
            e.printStackTrace();
        }

        if (firstTriangleSquare > secondTriangleSquare) {
            System.out.println("First triangle is greater" +
                    " ( " + firstTriangleSquare + " > " + secondTriangleSquare + " )");
        } else if (firstTriangleSquare < secondTriangleSquare) {
            System.out.println("Second triangle is greater" +
                    " ( " + firstTriangleSquare + " < " + secondTriangleSquare + " )");
        } else {
            System.out.println("The area of the triangles are equal" +
                    " ( " + firstTriangleSquare + " == " + secondTriangleSquare + " )");
        }
    }


}
