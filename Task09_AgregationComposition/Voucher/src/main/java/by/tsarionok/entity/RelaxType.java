package by.tsarionok.entity;

public enum RelaxType implements Guiding {
    SEA("Sea"), MOUNTAINS("Mountains");

    private final String name;

    private RelaxType(String s) {
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
