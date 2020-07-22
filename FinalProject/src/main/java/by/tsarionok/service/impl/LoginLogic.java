package by.tsarionok.service.impl;

import by.tsarionok.entity.User;
import by.tsarionok.exception.CustomException;
import by.tsarionok.service.UserService;

public class LoginLogic {

    // TODO: fix null pointer
    public static boolean checkLogin(String enterLogin, String enterPass) {
        UserService userService = new UserServiceImpl();
        User currentUser = null;
        try {
            currentUser = userService.findByLoginAndPassword(enterLogin, enterPass);
        } catch (CustomException e) {
            e.printStackTrace();
        }
        return currentUser != null;
    }
}
