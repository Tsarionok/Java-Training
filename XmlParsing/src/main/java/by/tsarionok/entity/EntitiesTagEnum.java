package by.tsarionok.entity;

public enum EntitiesTagEnum {
    ENTITIES("entities"),
    USER("user"),
    ROLE("role"),
    SERIAL("serial"),
    ID("id"),
    LOGIN("login"),
    PASSWORD("password"),
    USER_INFO("user-info"),
    PHONE_NUM("phone-num"),
    BIRTH_DATE("birth-date"),
    SEX("sex"),
    NAME("name"),
    PREMIER_DATE("premier-date"),
    IMAGE_PATH("image-path"),
    DESCRIPTION("description"),
    COUNTRY("country"),
    CATEGORY("category");

    private String value;

    EntitiesTagEnum(final String value) {
        this.value = value;
    }

    public final String getValue() {
        return value;
    }
}
