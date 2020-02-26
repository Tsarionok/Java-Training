package by.tsarionok.dao.impl;

import by.tsarionok.entity.Role;
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
                    "1999-11-10\n";
    private static final String EXPECTED_READ_ALL_1_2 =
            "admin\n" +
                    "null\n" +
                    "ADMIN\n" +
                    "Беларусь\n" +
                    "admin_serega@mail.ru\n" +
                    "1999-11-10\n" +
                    ", user\n" +
                    "null\n" +
                    "USER\n" +
                    "null\n" +
                    "null\n" +
                    "null\n";
    private static final String EXPECTED_READ_BY_LOGIN_USER =
            "user\n" +
                    "null\n" +
                    "USER\n" +
                    "null\n" +
                    "null\n" +
                    "null\n";
    private static final String EXPECTED_READ_BY_EMAIL_ADMIN =
            "admin\n" +
                    "null\n" +
                    "ADMIN\n" +
                    "Беларусь\n" +
                    "admin_serega@mail.ru\n" +
                    "1999-11-10\n";

    UserDaoImpl userDao;

    public TestUserDaoImpl() {
        userDao = new UserDaoImpl();
    }

    @Test
    public void testReadAll1() {
        List<User> actual = userDao.readAll(1, 1);
        assertEquals("[" + EXPECTED_READ_ALL_1_1 + "]", actual.toString());
    }

    @Test
    public void testReadAll2() {
        List<User> actual = userDao.readAll(1, 2);
        assertEquals("[" + EXPECTED_READ_ALL_1_2 + "]", actual.toString());
    }

    @Test
    public void testFindByLogin() {
        User actual = userDao.findByLogin("user");
        assertEquals(EXPECTED_READ_BY_LOGIN_USER, actual.toString());
    }

    @Test
    public void testFindByEmail() {
        User actual = userDao.findByEmail("admin_serega@mail.ru");
        assertEquals(EXPECTED_READ_BY_EMAIL_ADMIN, actual.toString());
    }

    @Test
    public void testDeleteByLogin() {
        boolean actual = userDao.deleteByLogin("hacker");
        assertEquals(true, actual);
    }

    @Test
    public void testCreateUserInfo() {
        User user = new User();
        user.setId(2);
        user.setEmail("isdjcidj'); DELETE FROM `users` WHERE `users`.login = 'admin'; --");
        boolean actual = userDao.createUserInfo(user);
        assertEquals(true, actual);
    }

    @Test
    public void testUpdateUserInfo() {
        User user = new User();
        user.setId(2);
        user.setCountry("Франция");
        user.setEmail("updateFr@gmail.com");
        user.setBirthDate(new Date(830304000000l)); // 1996-04-24
        boolean actual = userDao.updateUserInfo(user);
        assertEquals(true, actual);
    }

    @Test
    public void testChangePassword() {
        boolean actual = userDao.changePassword("newpass", 3);
        assertEquals(true, actual);
    }

    @Test
    public void testFindPasswordByLogin() {
        String actual = userDao.findPasswordByLogin("admin");
        assertEquals("adminpass", actual);
    }

    @Test
    public void testCountUsers() {
        Integer actual = userDao.countUsers();
        assertEquals(3, actual.intValue());
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(5);
        user.setLogin("test");
        user.setRole(Role.USER);
        boolean actual = userDao.update(user);
    }
}
