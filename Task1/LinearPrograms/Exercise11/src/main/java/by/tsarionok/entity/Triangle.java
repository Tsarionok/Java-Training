package by.tsarionok.entity;

public class Triangle {
    private double firstLegLength;
    private double secondLegLength;
    private double hypotenuseLength;

    public Triangle(double firstLegLength, double secondLegLength) {
        this.firstLegLength = firstLegLength;
        this.secondLegLength = secondLegLength;
        this.hypotenuseLength = Math.sqrt(Math.pow(this.firstLegLength, 2) + Math.pow(this.secondLegLength, 2));
    }

    public double getFirstLegLength() {
        return firstLegLength;
    }

    public void setFirstLegLength(double firstLegLength) {
        this.firstLegLength = firstLegLength;
    }

    public double getSecondLegLength() {
        return secondLegLength;
    }

    public void setSecondLegLength(double secondLegLength) {
        this.secondLegLength = secondLegLength;
    }

    public double getHypotenuseLength() {
        return hypotenuseLength;
    }

    public void setHypotenuseLength(double hypotenuseLength) {
        this.hypotenuseLength = Math.sqrt(Math.pow(this.firstLegLength, 2) + Math.pow(this.secondLegLength, 2));
    }
}
