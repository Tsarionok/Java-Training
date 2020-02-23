package by.tsarionok.dao.connetion;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectorDB {

    private static final Logger LOGGER = LogManager.getLogger(ConnectorDB.class);
    private static final String URL = "jdbc:mysql://localhost:3306/series_catalog_db";
    private static final String USER = "root";
    private static final String PASSWORD = "rootroot";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            LOGGER.fatal("Create connection error");
        }
        return connection;
    }
}
