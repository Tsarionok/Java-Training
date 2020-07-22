package by.tsarionok.service.impl;

import by.tsarionok.dao.UserDao;
import by.tsarionok.dao.impl.UserDaoImpl;
import by.tsarionok.entity.User;
import by.tsarionok.exception.CustomException;
import by.tsarionok.service.UserService;

import java.util.List;

public class UserServiceImpl extends ServiceImpl implements UserService {
    @Override
    public List<User> readAll(final int page, final int amountPerPage) throws CustomException {
        UserDao userDao = daoManager.createAndGetDao(UserDao.class);
        return userDao.readAll(page, amountPerPage);
    }

    @Override
    public User findByLoginAndPassword(final String login, final String pass) throws CustomException {
        if (!login.isEmpty() && !pass.isEmpty()) {
            UserDao userDao = new UserDaoImpl();
            String userPass = userDao.findPasswordByLogin(login);
            if (!userPass.isEmpty()) {
                return userPass.equals(pass) ? userDao.findByLogin(login) : null;
            } else {
                return null;
            }
        } else {
            throw new CustomException("Incorrect login or password");
        }
    }

}
