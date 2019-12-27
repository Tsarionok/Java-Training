package by.tsarionok.controller;

import by.tsarionok.entity.Point2D;
import by.tsarionok.service.TriangleService;

public class Runner {
    public static void main(String[] args) {
        Point2D point1 = new Point2D(3, 1);
        Point2D point2 = new Point2D(3, 4);
        Point2D point3 = new Point2D(5, 1);

        TriangleService triangleService = new TriangleService(point1, point2, point3);

        System.out.println(triangleService.findSquare());
    }
}
