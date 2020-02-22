package by.tsarionok.entity;

import java.util.Date;
import java.util.Objects;

public class Film extends Entity {
    private String name;
    private Date releaseDate;
    private String imageName;
    private String description;
    private String country;
    private String category;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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
        Film film = (Film) o;
        return Objects.equals(name, film.name) &&
                Objects.equals(releaseDate, film.releaseDate) &&
                Objects.equals(imageName, film.imageName) &&
                Objects.equals(description, film.description) &&
                Objects.equals(country, film.country) &&
                Objects.equals(category, film.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, releaseDate, imageName, description, country, category);
    }
}
