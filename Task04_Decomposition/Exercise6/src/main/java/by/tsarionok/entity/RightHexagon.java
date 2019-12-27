package by.tsarionok.entity;

import java.util.Objects;

public class RightHexagon {

    private double size;

    public RightHexagon(double size) {
        this.size = size;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RightHexagon that = (RightHexagon) o;
        return Double.compare(that.size, size) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(size);
    }

    @Override
    public String toString() {
        return "size = " + size;
    }
}
