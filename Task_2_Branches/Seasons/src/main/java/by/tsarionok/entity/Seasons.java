package by.tsarionok.entity;

public enum Seasons {
    WINTER("Winter"),
    SPRING("Spring"),
    SUMMER("Summer"),
    AUTUMN("Autumn");

    private String season;

    Seasons(String season) {
        this.season = season;
    }

    public String getSeason() {
        return season;
    }
}
