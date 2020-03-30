package by.tsarionok.service.impl;

import by.tsarionok.entity.User;
import by.tsarionok.exception.CustomException;
import by.tsarionok.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public List<User> readAll(int page, int amountPerPage) throws CustomException {
        return null;
    }
}
