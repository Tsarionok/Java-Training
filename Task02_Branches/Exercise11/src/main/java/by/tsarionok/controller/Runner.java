package by.tsarionok.controller;

import by.tsarionok.entity.Triangle;
import by.tsarionok.service.TrianglesAnalyzer;

public class Runner {
    public static void main(String[] args) {
        TrianglesAnalyzer trianglesAnalyzer = new TrianglesAnalyzer();
        Triangle triangle1 = new Triangle(3, 4, 5);
        Triangle triangle2 = new Triangle(12, 3.2, 9);
        trianglesAnalyzer.showGreatest(triangle1, triangle2);
    }
}
