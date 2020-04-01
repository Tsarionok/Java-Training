package by.tsarionok.entity;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Serial extends Entity {
    private String name;
    private Date premiereDate;
    private String imageName;
    private String description;
    private List<String> countries;
    private List<String> categories;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getPremiereDate() {
        return premiereDate;
    }

    public void setPremiereDate(Date premiereDate) {
        this.premiereDate = premiereDate;
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

    public List<String> getCountries() {
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Serial serial = (Serial) o;
        return Objects.equals(name, serial.name) &&
                Objects.equals(premiereDate, serial.premiereDate) &&
                Objects.equals(imageName, serial.imageName) &&
                Objects.equals(description, serial.description) &&
                Objects.equals(countries, serial.countries) &&
                Objects.equals(categories, serial.categories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, premiereDate, imageName, description, countries, categories);
    }

    @Override
    public String toString() {
        return "Serial{" +
                "name='" + name + '\'' +
                ", premierDate=" + premiereDate +
                ", imageName='" + imageName + '\'' +
                ", description='" + description + '\'' +
                ", country='" + countries + '\'' +
                ", category='" + categories + '\'' +
                '}';
    }
}
