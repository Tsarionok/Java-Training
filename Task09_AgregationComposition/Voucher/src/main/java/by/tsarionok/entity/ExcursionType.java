package by.tsarionok.entity;

public enum ExcursionType implements Guiding {
    ONE_DAY("One"), MANY_DAY("Many");

    private final String name;

    private ExcursionType(String s) {
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
