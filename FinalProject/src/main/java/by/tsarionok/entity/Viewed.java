package by.tsarionok.entity;

import java.util.Objects;

public class Viewed extends Entity {
    private User user;
    private Serial serial;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Serial getSerial() {
        return serial;
    }

    public void setSerial(Serial serial) {
        this.serial = serial;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Viewed viewed = (Viewed) o;
        return Objects.equals(user, viewed.user) &&
                Objects.equals(serial, viewed.serial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), user, serial);
    }
}
