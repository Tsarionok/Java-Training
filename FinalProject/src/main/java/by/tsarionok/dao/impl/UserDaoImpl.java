package by.tsarionok.dao.impl;

import by.tsarionok.dao.BaseDao;
import by.tsarionok.dao.UserDao;
import by.tsarionok.entity.Role;
import by.tsarionok.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class UserDaoImpl extends BaseDao implements UserDao {
    private static final Logger LOGGER = LogManager.getLogger(UserDaoImpl.class);

    private static final String SELECT_ALL = "SELECT " +
            "`users`.id, " +
            "`users`.login, " +
            "`users`.role, " +
            "`user_info`.email, " +
            "`user_info`.sex, " +
            "`user_info`.birth_date, " +
            "`countries`.name AS `country` FROM `users` " +
            "LEFT OUTER JOIN `user_info` ON `users`.id = `user_id` " +
            "LEFT OUTER JOIN `countries` ON `user_info`.country_id = `countries`.id " +
            "LIMIT ? OFFSET ?;";

    private static final String SELECT_BY_LOGIN = "SELECT `users`.id, " +
            "`users`.login, " +
            "`users`.role, " +
            "`user_info`.email, " +
            "`user_info`.sex, " +
            "`user_info`.birth_date, " +
            "`countries`.name AS `country` FROM `users` " +
            "LEFT OUTER JOIN `user_info` ON `users`.id = `user_id` " +
            "LEFT OUTER JOIN `countries` ON `user_info`.country_id = `countries`.id " +
            "WHERE `users`.login = ?;";

    private static final String SELECT_BY_EMAIL = "SELECT `users`.id, " +
            "`users`.login, " +
            "`users`.role, " +
            "`user_info`.email, " +
            "`user_info`.sex, " +
            "`user_info`.birth_date, " +
            "`countries`.name AS `country` FROM `users` " +
            "LEFT OUTER JOIN `user_info` ON `users`.id = `user_id` " +
            "LEFT OUTER JOIN `countries` ON `user_info`.country_id = `countries`.id " +
            "WHERE `user_info`.email = ?;";

    private static final String DELETE_BY_LOGIN = "DELETE FROM `users` WHERE `users`.login = ?;";

    private static final String CREATE_USER_INFO = "INSERT INTO `user_info` (user_id, email) VALUES (?, ?);";

    private static final String SELECT_COUNTRY_BY_NAME = "SELECT " +
            "`countries`.id AS `country_id` " +
            "FROM `countries` WHERE `countries`.name = ?;";

    private static final String UPDATE_USER_INFO = "UPDATE `user_info` SET " +
            "`user_info`.country_id = ?, " +
            "`user_info`.email = ?, " +
            "`user_info`.sex = ?, " +
            "`user_info`.birth_date = ? WHERE `user_info`.user_id = ?;";


    @Override
    public List<User> readAll(int pageNumber, int amountPerPage) {
        List<User> users = new LinkedList<>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(SELECT_ALL);
            statement.setInt(1, amountPerPage);
            statement.setInt(2, (pageNumber - 1) * amountPerPage);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setLogin(resultSet.getString("login"));
                user.setRole(Role.findById(resultSet.getInt("role")));
                user.setEmail(resultSet.getString("email"));
                user.setSex(resultSet.getString("sex"));
                user.setBirthDate(resultSet.getDate("birth_date"));
                user.setCountry(resultSet.getString("country"));
                users.add(user);
            }
        } catch (SQLException e) {
            LOGGER.error("Select all error", e);
        } finally {
            try {
                closeResources(statement, resultSet);
            } catch (SQLException e) {
                LOGGER.error("Resource close error", e);
            }
        }
        return users;
    }

    @Override
    public User findByLogin(String login) {
        User user = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(SELECT_BY_LOGIN);
            statement.setString(1, login);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setLogin(resultSet.getString("login"));
                user.setRole(Role.findById(resultSet.getInt("role")));
                user.setEmail(resultSet.getString("email"));
                user.setSex(resultSet.getString("sex"));
                user.setBirthDate(resultSet.getDate("birth_date"));
                user.setCountry(resultSet.getString("country"));
            }
        } catch (SQLException e) {
            LOGGER.error("Select by login error", e);
        } finally {
            try {
                closeResources(statement, resultSet);
            } catch (SQLException e) {
                LOGGER.error("Resource close error");
            }
        }
        return user;
    }

    @Override
    public User findByEmail(final String email) {
        User user = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(SELECT_BY_EMAIL);
            statement.setString(1, email);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setLogin(resultSet.getString("login"));
                user.setRole(Role.findById(resultSet.getInt("role")));
                user.setEmail(resultSet.getString("email"));
                user.setSex(resultSet.getString("sex"));
                user.setBirthDate(resultSet.getDate("birth_date"));
                user.setCountry(resultSet.getString("country"));
            }
        } catch (SQLException e) {
            LOGGER.error("Select by email exception", e);
        } finally {
            try {
                closeResources(statement, resultSet);
            } catch (SQLException e) {
                LOGGER.error("Resource close error");
            }
        }
        return user;
    }

    @Override
    public boolean deleteByLogin(final String login) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_LOGIN)) {
            preparedStatement.setString(1, login);
            return preparedStatement.executeUpdate() != 0;
        } catch (SQLException e) {
            LOGGER.error("Delete by login exception", e);
        }
        return false;
    }

    @Override
    public boolean updateUserInfo(final User user) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            Integer countryId = null;
            if (user.getCountry() != null && !user.getCountry().isEmpty()) {
                statement = connection.prepareStatement(SELECT_COUNTRY_BY_NAME);
                statement.setString(1, user.getCountry());
                resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    countryId = resultSet.getInt("country_id");
                } else {
                    return false;
                }
                closeResources(statement, resultSet);
            }
            statement = connection.prepareStatement(UPDATE_USER_INFO);

            if (user.getCountry() != null) {
                statement.setInt(1, countryId);
            } else {
                statement.setNull(1, Types.INTEGER);
            }
            if (user.getEmail() != null) {
                statement.setString(2, user.getEmail());
            } else {
                statement.setNull(2, Types.VARCHAR);
            }
            if (user.getSex() != null) {
                statement.setString(3, user.getSex());
            } else {
                statement.setNull(3, Types.CHAR);
            }
            if (user.getBirthDate() != null) {
                statement.setDate(4, new Date(user.getBirthDate().getTime()));
            } else {
                statement.setNull(4, Types.DATE);
            }
            statement.setInt(5, user.getId());
            return statement.executeUpdate() != 0;
        } catch (SQLException e) {
            LOGGER.error("Update user info exception", e);
        } finally {
            try {
                closeResources(statement, resultSet);
            } catch (SQLException e) {
                LOGGER.error("Close resources exception", e);
            }
        }
        return false;
    }

    @Override
    public boolean createUserInfo(final User user) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(CREATE_USER_INFO)) {
            preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(2, user.getLogin());
            return preparedStatement.executeUpdate() != 0;
        } catch (SQLException e) {
            LOGGER.error("Insert user info exception", e);
        }
        return false;
    }

    @Override
    public boolean changePassword(String pass, int userId) {
        return false;
    }

    @Override
    public String findPasswordByLogin(String login) {
        return null;
    }

    @Override
    public Integer countUsers() {
        return null;
    }

    @Override
    public User findById(Integer id) {
        return null;
    }

    @Override
    public Integer create(User entity) {
        return null;
    }

    @Override
    public boolean update(User entity) {
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }
}
