package by.tsarionok.entity;

import java.util.Objects;

public class SeeLater extends Entity {
    private User user;
    private Film film;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
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
        SeeLater seeLater = (SeeLater) o;
        return Objects.equals(user, seeLater.user) &&
                Objects.equals(film, seeLater.film);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), user, film);
    }
}
