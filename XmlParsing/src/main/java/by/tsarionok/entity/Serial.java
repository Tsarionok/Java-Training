package by.tsarionok.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Serial extends Entity {
    private String name;
    private Date premiereDate;
    private String imgPath;
    private String description;
    private List<String> countries;
    private List<String> categories;

    public Serial() {
        countries = new ArrayList<>();
        categories = new ArrayList<>();
    }

    public Serial(long id, String name, Date premiereDate, String imgPath, String description, List<String> countries, List<String> categories) {
        super(id);
        this.name = name;
        this.premiereDate = premiereDate;
        this.imgPath = imgPath;
        this.description = description;
        this.countries = countries;
        this.categories = categories;
    }

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

    public List<String> getCountries() {
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    public void setCountry(String country) {
        countries.add(country);
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public void setCategory(String category) {
        categories.add(category);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Serial serial = (Serial) o;
        return Objects.equals(name, serial.name) &&
                Objects.equals(premiereDate, serial.premiereDate) &&
                Objects.equals(imgPath, serial.imgPath) &&
                Objects.equals(description, serial.description) &&
                Objects.equals(countries, serial.countries) &&
                Objects.equals(categories, serial.categories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, premiereDate, imgPath, description, countries, categories);
    }

    @Override
    public String toString() {
        return "\nSerial{\n" +
                super.toString() +
                "\nname='" + name + '\'' +
                ",\npremiereDate=" + premiereDate +
                ",\nimgPath='" + imgPath + '\'' +
                ",\ndescription='" + description + '\'' +
                ",\ncountries=" + countries +
                ",\ncategories=" + categories +
                "\n}\n";
    }
}
