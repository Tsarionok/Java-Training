package by.tsarionok.entity;

public enum Role {
    ADMIN("admin"),
    EDITOR("editor"),
    USER("user"),
    UNAUTHORIZED("unauthorized");

    private String value;

    Role(final String role) {
        value = role;
    }

    public static Role findById(final Integer id) {
        return Role.values()[id];
    }

    public String getValue() {
        return value;
    }


}
