package by.tsarionok.dao.impl;

import by.tsarionok.entity.User;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestUserDaoImpl {

    private static final String EXPECTED_READ_ALL_1_1 =
            "admin\n" +
                    "null\n" +
                    "ADMIN\n" +
                    "Беларусь\n" +
                    "admin_serega@mail.ru\n" +
                    "м\n" +
                    "1999-11-10\n";
    private static final String EXPECTED_READ_ALL_1_2 =
            "admin\n" +
                    "null\n" +
                    "ADMIN\n" +
                    "Беларусь\n" +
                    "admin_serega@mail.ru\n" +
                    "м\n" +
                    "1999-11-10\n" +
                    ", editor\n" +
                    "null\n" +
                    "EDITOR\n" +
                    "Россия\n" +
                    "maria@gmail.com\n" +
                    "ж\n" +
                    "null\n";
    private static final String EXPECTED_READ_BY_LOGIN_ADMIN =
            "user\n" +
                    "null\n" +
                    "USER\n" +
                    "null\n" +
                    "null\n" +
                    "null\n" +
                    "null\n";


    @Test
    public void readAll1() {
        UserDaoImpl userDao = new UserDaoImpl();
        List<User> actual = userDao.readAll(1, 1);
        assertEquals("[" + EXPECTED_READ_ALL_1_1 + "]", actual.toString());
    }

    @Test
    public void readAll2() {
        UserDaoImpl userDao = new UserDaoImpl();
        List<User> actual = userDao.readAll(1, 2);
        assertEquals("[" + EXPECTED_READ_ALL_1_2 + "]", actual.toString());
    }

    @Test
    public void findByLogin() {
        UserDaoImpl userDao = new UserDaoImpl();
        User actual = userDao.findByLogin("user888");
        System.out.println(actual);
        assertEquals(EXPECTED_READ_BY_LOGIN_ADMIN, actual.toString());
    }
}
