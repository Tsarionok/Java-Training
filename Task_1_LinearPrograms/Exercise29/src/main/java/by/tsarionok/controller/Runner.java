package by.tsarionok.controller;

import by.tsarionok.entity.Triangle;
import by.tsarionok.service.TriangleAngles;

public class Runner {
    public static void main(String[] args) {
        TriangleAngles triangleAngles = new TriangleAngles(new Triangle(3, 4, 5));

        double[] angles = triangleAngles.convertToDegrees();

        for (double angle : angles) {
            System.out.println(angle);
        }
    }
}
