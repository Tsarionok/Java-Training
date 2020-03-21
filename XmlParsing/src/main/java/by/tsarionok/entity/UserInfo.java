package by.tsarionok.entity;

import java.util.Date;
import java.util.Objects;

public class UserInfo {
    private String sex;
    private Date birthDate;
    private String phoneNumber;

    public UserInfo() {
    }

    public UserInfo(String sex, Date birthDate, String phoneNumber) {
        this.sex = sex;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInfo userInfo = (UserInfo) o;
        return Objects.equals(sex, userInfo.sex) &&
                Objects.equals(birthDate, userInfo.birthDate) &&
                Objects.equals(phoneNumber, userInfo.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sex, birthDate, phoneNumber);
    }

    @Override
    public String toString() {
        return "\nUserInfo{\n" +
                "sex='" + sex + '\'' +
                ",\nbirthDate=" + birthDate +
                ",\nphoneNumber='" + phoneNumber + '\'' +
                "\n}";
    }
}
