package by.tsarionok.entity;

import java.util.Objects;

public class User extends Entity {
    private String login;
    private String password;
    private Integer role;
    private UserInfo info;

    public User() {
        info = new UserInfo();
    }

    public User(long id, String login, String password, int role, UserInfo info) {
        super(id);
        this.login = login;
        this.password = password;
        this.role = role;
        this.info = info;
    }

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

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public UserInfo getInfo() {
        return info;
    }

    public void setInfo(UserInfo info) {
        this.info = info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return role == user.role &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                Objects.equals(info, user.info);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), login, password, role, info);
    }

    @Override
    public String toString() {
        return "\nUser{\n" +
                super.toString() +
                "\nlogin='" + login + '\'' +
                ",\npassword='" + password + '\'' +
                ",\nrole=" + role +
                ",\ninfo=" + info +
                "\n}\n";
    }
}
