package by.tsarionok.dao;

import by.tsarionok.entity.User;

import java.util.List;

public interface UserDao extends Dao<User> {
    List<User> readAll(int pageNumber, int amountPerPage);

    User findByLogin(String login);

    boolean deleteByLogin(String login);

    boolean updateUserInfo(User user);

    boolean createUserInfo(User user);

    boolean changePassword(String pass, int userId);

    String findPasswordByLogin(String login);

    Integer countUsers();
}
