package by.tsarionok.dao.impl;

import by.tsarionok.dao.BaseDao;
import by.tsarionok.dao.SerialDao;
import by.tsarionok.entity.Serial;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class SerialDaoImpl extends BaseDao implements SerialDao {
    private static final Logger LOGGER = LogManager.getLogger(BaseDao.class);

    private static final String SELECT_ALL = "SELECT " +
            "`serials`.id, " +
            "`serials`.name, " +
            "`serials`.premiere_date, " +
            "`serials`.image_path, " +
            "`serials`.description " +
            "FROM `serials` " +
            "ORDER BY `serials`.id LIMIT ? OFFSET ?;";

    private static final String SELECT_BY_NAME = "SELECT `serials`.id, \n" +
            "\t\t`serials`.name, \n" +
            "\t\t`serials`.premiere_date, " +
            "`serials`.image_path, " +
            "`serials`.description " +
            "FROM `serials` \n" +
            "WHERE `serials`.name = ?;";

    @Override
    public List<Serial> readAll(final int pageNumber, final int amountPerPage) {
        List<Serial> serials = new LinkedList<>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(SELECT_ALL);
            statement.setInt(1, amountPerPage);
            statement.setInt(2, (pageNumber - 1) * amountPerPage);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Serial serial = new Serial();
                serial.setId(resultSet.getInt("id"));
                serial.setName(resultSet.getString("name"));
                serial.setPremiereDate(resultSet.getDate("premier_date"));
                serial.setImageName(resultSet.getString("image_path"));
                serial.setDescription(resultSet.getString("description"));
                serials.add(serial);
            }
        } catch (SQLException e) {
            LOGGER.error("Select all serials exception", e);
        } finally {
            try {
                closeResources(statement, resultSet);
            } catch (SQLException e) {
                LOGGER.error("Resource close exception", e);
            }
        }
        return serials;
    }

    @Override
    public List<Serial> findByName(final String name) {
        List<Serial> serials = new LinkedList<>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(SELECT_BY_NAME);
            statement.setString(1, name);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Serial serial = new Serial();
                serial.setId(resultSet.getInt("id"));
                serial.setName(resultSet.getString("name"));
                serial.setPremiereDate(resultSet.getDate("premier_date"));
                serial.setImageName(resultSet.getString("image_path"));
                serial.setDescription(resultSet.getString("description"));
                serials.add(serial);
            }
        } catch (SQLException e) {
            LOGGER.error("Select by serial name exception", e);
        } finally {
            try {
                closeResources(statement, resultSet);
            } catch (SQLException e) {
                LOGGER.error("Resource close exception", e);
            }
        }
        return serials;
    }

    @Override
    public List<Serial> findByCategory(String category) {
        return null;
    }

    @Override
    public Integer countFilms() {
        return null;
    }

    @Override
    public Serial findById(Integer id) {
        return null;
    }

    @Override
    public Integer create(Serial entity) {
        return null;
    }

    @Override
    public boolean update(Serial entity) {
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }
}
