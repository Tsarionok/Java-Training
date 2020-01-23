package by.tsarionok.entity;

public enum CruiseType implements Guiding {
    SEA("Sea"), RIVER("River");

    private final String name;

    private CruiseType(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {

        return name.equals(otherName);
    }

    @Override
    public String toString() {
        return this.name;
    }

}
