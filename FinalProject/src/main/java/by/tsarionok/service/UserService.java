package by.tsarionok.service;

import by.tsarionok.entity.User;
import by.tsarionok.exception.CustomException;

import java.util.List;

public interface UserService {
    List<User> readAll(int page, int amountPerPage)
            throws CustomException;

    Integer countUsers() throws CustomException;

    User findByLoginAndPassword(String login, String password)
            throws CustomException;

    User findById(Integer id) throws CustomException;

    boolean delete(Integer id) throws CustomException;

    boolean deleteByLogin(String login) throws CustomException;

    Integer create(User user) throws CustomException;

    boolean update(User user) throws CustomException;

    boolean changePassword(String pass, int userId)
            throws CustomException;

    User findByLogin(String login) throws CustomException;

    User findByEmail(String email) throws CustomException;

    String findPassByLogin(String login) throws CustomException;
}
