package by.tsarionok.service;

import by.tsarionok.entity.Point2D;

public class TriangleService {
    Point2D point1;
    Point2D point2;
    Point2D point3;

    public TriangleService(Point2D point1, Point2D point2, Point2D point3) {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
    }

    public double findSquare() throws IllegalArgumentException {
        double square = Math.abs(point3.getY() * (point2.getX() - point1.getX()) +
                point1.getY() * (point3.getX() - point2.getX()) +
                point2.getY() * (point1.getX() - point3.getX())) / 2;
        if (square > 0) {
            return square;
        } else {
            throw new IllegalArgumentException("Triangle square must be more than 0");
        }

    }
}
