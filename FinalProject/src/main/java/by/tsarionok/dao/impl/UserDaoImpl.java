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
            "`user_info`.birth_date, " +
            "`countries`.name AS `country` FROM `users` " +
            "LEFT OUTER JOIN `user_info` ON `users`.id = `user_id` " +
            "LEFT OUTER JOIN `countries` ON `user_info`.country_id = `countries`.id ORDER BY `users`.id " +
            "LIMIT ? OFFSET ?;";

    private static final String SELECT_BY_ID = "SELECT `users`.id, " +
            "`users`.login, " +
            "`users`.role, " +
            "`user_info`.email, " +
            "`user_info`.birth_date, " +
            "`countries`.name AS `country` FROM `users` " +
            "LEFT OUTER JOIN `user_info` ON `users`.id = `user_id` " +
            "LEFT OUTER JOIN `countries` ON `user_info`.country_id = `countries`.id " +
            "WHERE `users`.id = ?;";

    private static final String SELECT_BY_LOGIN = "SELECT `users`.id, " +
            "`users`.login, " +
            "`users`.role, " +
            "`user_info`.email, " +
            "`user_info`.birth_date, " +
            "`countries`.name AS `country` FROM `users` " +
            "LEFT OUTER JOIN `user_info` ON `users`.id = `user_id` " +
            "LEFT OUTER JOIN `countries` ON `user_info`.country_id = `countries`.id " +
            "WHERE `users`.login = ?;";

    private static final String SELECT_BY_EMAIL = "SELECT `users`.id, " +
            "`users`.login, " +
            "`users`.role, " +
            "`user_info`.email, " +
            "`user_info`.birth_date, " +
            "`countries`.name AS `country` FROM `users` " +
            "LEFT OUTER JOIN `user_info` ON `users`.id = `user_id` " +
            "LEFT OUTER JOIN `countries` ON `user_info`.country_id = `countries`.id " +
            "WHERE `user_info`.email = ?;";

    private static final String DELETE = "DELETE FROM `users` WHERE id = ?;";

    private static final String DELETE_BY_LOGIN = "DELETE FROM `users` WHERE `users`.login = ?;";

    private static final String CREATE = "INSERT INTO `users`(login, password, role) VALUES (?, ?, ?);";

    private static final String CREATE_USER_INFO = "INSERT INTO `user_info` (user_id, email) VALUES (?, ?);";

    private static final String SELECT_COUNTRY_BY_NAME = "SELECT " +
            "`countries`.id AS `country_id` " +
            "FROM `countries` WHERE `countries`.name = ?;";

    private static final String UPDATE = "UPDATE `users` SET login = ?, role = ? WHERE id = ?;";

    private static final String UPDATE_USER_INFO = "UPDATE `user_info` SET " +
            "`user_info`.country_id = ?, " +
            "`user_info`.email = ?, " +
            "`user_info`.birth_date = ? WHERE `user_info`.user_id = ?;";

    private static final String CHANGE_PASSWORD = "UPDATE `users` SET password = ? WHERE id = ?; ";

    private static final String SELECT_PASSWORD_BY_LOGIN = "SELECT `users`.password FROM `users` " +
            "WHERE `users`.login = ?;";

    private static final String COUNT_USERS = "SELECT COUNT(id) AS `count_users` FROM `users`;";

    @Override
    public List<User> readAll(final int pageNumber, final int amountPerPage) {
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
                user.setBirthDate(resultSet.getDate("birth_date"));
                user.setCountry(resultSet.getString("country"));
                users.add(user);
            }
        } catch (SQLException e) {
            LOGGER.error("Select all exception", e);
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
    public User findByLogin(final String login) {
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
            if (user.getBirthDate() != null) {
                statement.setDate(3, new Date(user.getBirthDate().getTime()));
            } else {
                statement.setNull(3, Types.DATE);
            }
            statement.setInt(4, user.getId());
            return statement.executeUpdate() != 0;
        } catch (SQLException e) {
            LOGGER.error("Update user info exception", e);
        } finally {
            try {
                closeResources(statement, resultSet);
            } catch (SQLException e) {
                LOGGER.error("Resource close exception", e);
            }
        }
        return false;
    }

    @Override
    public boolean createUserInfo(final User user) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(CREATE_USER_INFO)) {
            preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(2, user.getEmail());
            return preparedStatement.executeUpdate() != 0;
        } catch (SQLException e) {
            LOGGER.error("Insert user info exception", e);
        }
        return false;
    }

    @Override
    public boolean changePassword(final String pass, final int userId) {
        try (PreparedStatement statement = connection.prepareStatement(CHANGE_PASSWORD)) {
            statement.setString(1, pass);
            statement.setInt(2, userId);
            return statement.executeUpdate() != 0;
        } catch (SQLException e) {
            LOGGER.error("Changing password exception", e);
        }
        return false;
    }

    @Override
    public String findPasswordByLogin(final String login) {
        String pass = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(SELECT_PASSWORD_BY_LOGIN);
            statement.setString(1, login);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                pass = resultSet.getString("password");
            }
        } catch (SQLException e) {
            LOGGER.error("Select pass by login exception", e);
        } finally {
            try {
                closeResources(statement, resultSet);
            } catch (SQLException e) {
                LOGGER.error("Resource close exception");
            }
        }
        return pass;
    }

    @Override
    public Integer countUsers() {
        Integer count = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(COUNT_USERS);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                count = resultSet.getInt("count_users");
            }
        } catch (SQLException e) {
            LOGGER.error("Count users exception", e);
        } finally {
            try {
                closeResources(statement, resultSet);
            } catch (SQLException e) {
                LOGGER.error("Resource close exception", e);
            }
        }
        return count;
    }

    @Override
    public User findById(final Integer id) {
        User user = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(SELECT_BY_ID);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user.setId(resultSet.getInt("id"));
                user.setLogin(resultSet.getString("login"));
                user.setRole(Role.findById(resultSet.getInt("role")));
                user.setEmail(resultSet.getString("email"));
                user.setBirthDate(resultSet.getDate("birth_date"));
                user.setCountry(resultSet.getString("country"));
            }
        } catch (SQLException e) {
            LOGGER.error("Select by ID exception", e);
        } finally {
            try {
                closeResources(statement, resultSet);
            } catch (SQLException e) {
                LOGGER.error("Resource close exception", e);
            }
        }
        return user;
    }

    @Override
    public Integer create(User entity) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, entity.getLogin());
            statement.setString(2, entity.getPassword());
            statement.setInt(3, entity.getRole().ordinal());
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            } else {
                LOGGER.error("There isn't generated key "
                        + "after add into table");
            }
        } catch (SQLException e) {
            LOGGER.error("Prepare statement error", e);
        } finally {
            try {
                closeResources(statement, resultSet);
            } catch (SQLException e) {
                LOGGER.error("Resource close error", e);
            }
        }
        return 0;
    }

    @Override
    public boolean update(final User user) {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE)) {
            statement.setString(1, user.getLogin());
            statement.setInt(2, user.getRole().ordinal());
            statement.setInt(3, user.getId());
            return statement.executeUpdate() != 0;
        } catch (SQLException e) {
            LOGGER.error("Update user exception", e);
        }
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        try (PreparedStatement statement = connection.prepareStatement(DELETE)) {
            statement.setInt(1, id);
            return statement.executeUpdate() != 0;
        } catch (SQLException e) {
            LOGGER.error("Delete user exception");
        }
        return false;
    }
}
