package by.tsarionok.validator;

import by.tsarionok.entity.RightHexagon;

public class RightHexagonValidator {
    public boolean isHexagon(RightHexagon hexagon) {
        if (hexagon.getSize() <= 0) {
            return false;
        }
        return true;
    }
}
