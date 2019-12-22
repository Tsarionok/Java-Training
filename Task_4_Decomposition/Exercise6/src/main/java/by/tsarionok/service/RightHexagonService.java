package by.tsarionok.service;

import by.tsarionok.entity.RightHexagon;
import by.tsarionok.exception.RightHexagonException;
import by.tsarionok.validator.RightHexagonValidator;

public class RightHexagonService {

    private final double SQRT_3 = Math.sqrt(3.d);
    private final double SIZES_NUM = 6;

    private RightHexagon hexagon;
    private RightHexagonValidator validator;

    public RightHexagonService(RightHexagon hexagon) {
        this.hexagon = hexagon;
    }

    public double hexagonSquare() throws RightHexagonException {
        validator = new RightHexagonValidator();
        if (validator.isHexagon(hexagon)) {
            return SIZES_NUM * rightTriangleSquare(hexagon.getSize());
        } else {
            throw new RightHexagonException("Size must be positive");
        }
    }

    private double rightTriangleSquare(double size) {
        // The equation for calculating the area of an equilateral triangle
        return (SQRT_3 / 4) * size * size;
    }
}
