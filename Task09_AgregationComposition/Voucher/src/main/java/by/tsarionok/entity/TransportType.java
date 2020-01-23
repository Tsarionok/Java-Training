package by.tsarionok.entity;

public enum TransportType implements Guiding {
    CAR("Car"),
    PLAIN("Plain"),
    BUS("Bus"),
    LINER("Liner");

    private final String name;

    private TransportType(String s) {
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
