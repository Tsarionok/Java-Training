package by.tsarionok.dao.impl;

import by.tsarionok.entity.User;
import org.junit.Test;

import java.util.Date;
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
    private static final String EXPECTED_READ_BY_EMAIL_ADMIN =
            "admin\n" +
                    "null\n" +
                    "ADMIN\n" +
                    "Беларусь\n" +
                    "admin_serega@mail.ru\n" +
                    "м\n" +
                    "1999-11-10\n";

    UserDaoImpl userDao;

    public TestUserDaoImpl() {
        userDao = new UserDaoImpl();
    }

    @Test
    public void readAll1() {
        List<User> actual = userDao.readAll(1, 1);
        assertEquals("[" + EXPECTED_READ_ALL_1_1 + "]", actual.toString());
    }

    @Test
    public void readAll2() {
        List<User> actual = userDao.readAll(1, 2);
        assertEquals("[" + EXPECTED_READ_ALL_1_2 + "]", actual.toString());
    }

    @Test
    public void findByLogin() {
        User actual = userDao.findByLogin("user");
        assertEquals(EXPECTED_READ_BY_LOGIN_ADMIN, actual.toString());
    }

    @Test
    public void findByEmail() {
        User actual = userDao.findByEmail("admin_serega@mail.ru");
        assertEquals(EXPECTED_READ_BY_EMAIL_ADMIN, actual.toString());
    }

    @Test
    public void deleteByLogin() {
        boolean actual = userDao.deleteByLogin("hacker");
        assertEquals(true, actual);
    }

    @Test
    public void createUserInfo() {
        User user = new User();
        user.setId(2);
        user.setEmail("example@gmail.com");
        boolean actual = userDao.createUserInfo(user);
        assertEquals(true, actual);
    }

    @Test
    public void updateUserInfo() {
        User user = new User();
        user.setId(2);
        user.setCountry("Франция");
        user.setEmail("updateFr@gmail.com");
        user.setBirthDate(new Date(830304000000l)); // 1996-04-24
        boolean actual = userDao.updateUserInfo(user);
        assertEquals(true, actual);
    }

    @Test
    public void changePassword() {
        boolean actual = userDao.changePassword("newpass", 2);
        assertEquals(true, actual);
    }
}
