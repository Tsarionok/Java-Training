package by.tsarionok.controller;

import by.tsarionok.entity.Triangle;
import by.tsarionok.service.TriangleAnalyzable;
import by.tsarionok.service.TriangleAnalyzer;

public class Runner {
    public static void main(String[] args) {
        TriangleAnalyzable triangleAnalyzable = new TriangleAnalyzer(new Triangle(1, 2));
        System.out.println("Square: " + triangleAnalyzable.showSquare() +
                "\nPerimeter: " + triangleAnalyzable.showPerimeter());
    }
}
