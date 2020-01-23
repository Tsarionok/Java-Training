package by.tsarionok.entity;

public enum TherapeuticType implements Guiding {
    FITNESS("Fitness"),
    SPA("Spa"),
    WEIGHT_LOSS("Weight_loss");

    private final String name;

    private TherapeuticType(String s) {
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
