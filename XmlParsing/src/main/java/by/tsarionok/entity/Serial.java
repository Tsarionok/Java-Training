package by.tsarionok.entity;

import java.util.Date;
import java.util.Objects;

public class Serial extends Entity {
    private String name;
    private Date premierDate;
    private String imgPath;
    private String description;
    private String country;
    private String category;

    public Serial() {
    }

    public Serial(long id, String name, Date premiereDate, String imgPath, String description, String country, String category) {
        super(id);
        this.name = name;
        this.premierDate = premiereDate;
        this.imgPath = imgPath;
        this.description = description;
        this.country = country;
        this.category = category;
    }

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

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Serial serial = (Serial) o;
        return Objects.equals(name, serial.name) &&
                Objects.equals(premierDate, serial.premierDate) &&
                Objects.equals(imgPath, serial.imgPath) &&
                Objects.equals(description, serial.description) &&
                Objects.equals(country, serial.country) &&
                Objects.equals(category, serial.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, premierDate, imgPath, description, country, category);
    }

    @Override
    public String toString() {
        return "\nSerial{\n" +
                super.toString() +
                "\nname='" + name + '\'' +
                ",\npremiereDate=" + premierDate +
                ",\nimgPath='" + imgPath + '\'' +
                ",\ndescription='" + description + '\'' +
                ",\ncountries=" + country +
                ",\ncategories=" + category +
                "\n}\n";
    }
}
