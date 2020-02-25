package by.tsarionok.entity;

import java.util.Date;
import java.util.Objects;

public class User extends Entity {
    private String login;
    private String password;
    private Role role;
    private String country;
    private String email;
    private Date birthDate;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
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
        User user = (User) o;
        return Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                role == user.role &&
                Objects.equals(country, user.country) &&
                Objects.equals(email, user.email) &&
                Objects.equals(birthDate, user.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), login, password, role, country, email, birthDate);
    }

    // этот toString пока использую для тестов, возможно в будущем - деприкейтед =)
    @Override
    public String toString() {
        return "" +
                login + '\n' +
                password + '\n' +
                role + '\n' +
                country + '\n' +
                email + '\n' +
                birthDate + '\n';
    }
}
