package by.tsarionok.entity;

import java.util.Date;
import java.util.Objects;

public class Serial extends Entity {
    private String name;
    private Date premierDate;
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

    public Date getPremierDate() {
        return premierDate;
    }

    public void setPremierDate(Date premierDate) {
        this.premierDate = premierDate;
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
        Serial serial = (Serial) o;
        return Objects.equals(name, serial.name) &&
                Objects.equals(premierDate, serial.premierDate) &&
                Objects.equals(imageName, serial.imageName) &&
                Objects.equals(description, serial.description) &&
                Objects.equals(country, serial.country) &&
                Objects.equals(category, serial.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, premierDate, imageName, description, country, category);
    }

    @Override
    public String toString() {
        return "Serial{" +
                "name='" + name + '\'' +
                ", premierDate=" + premierDate +
                ", imageName='" + imageName + '\'' +
                ", description='" + description + '\'' +
                ", country='" + country + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
