package by.tsarionok.service;

import by.tsarionok.entity.User;
import by.tsarionok.exception.CustomException;

import java.util.List;

public interface UserService extends Service {
    List<User> readAll(int page, int amountPerPage) throws CustomException;

    User findByLoginAndPassword(final String login, final String password) throws CustomException;
}
