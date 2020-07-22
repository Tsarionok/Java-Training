package by.tsarionok.dao.impl;


import by.tsarionok.dao.*;
import by.tsarionok.exception.CustomException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DaoManagerImpl implements DaoManager {
    private static final Logger LOGGER = LogManager.getLogger(DaoManagerImpl.class);
    private static final Map<Class<? extends Dao<?>>,
            Class<? extends BaseDao>> DAO_MAP = new ConcurrentHashMap<>();

    static {
        DAO_MAP.put(SerialDao.class, SerialDaoImpl.class);
        DAO_MAP.put(UserDao.class, UserDaoImpl.class);
        DAO_MAP.put(SeeLaterDaoImpl.class, SeeLaterDaoImpl.class);
        DAO_MAP.put(ViewedDao.class, ViewedDaoImpl.class);
    }

    private Connection connection;

    DaoManagerImpl(final Connection dbConnection) {
        connection = dbConnection;
    }

    @Override
    public <T extends Dao<?>> T createAndGetDao(final Class<T> key)
            throws CustomException {
        Class<? extends BaseDao> daoClass = DAO_MAP.get(key);
        if (daoClass != null) {
            try {
                BaseDao dao = daoClass.getDeclaredConstructor().newInstance();
                dao.setConnection(connection);
                return (T) dao;
            } catch (InstantiationException | IllegalAccessException
                    | InvocationTargetException | NoSuchMethodException e) {
                LOGGER.error("Class initialize error", e);
                throw new CustomException(e);
            }
        }
        return null;
    }

    @Override
    public void commit() throws CustomException {
        try {
            connection.commit();
        } catch (SQLException e) {
            LOGGER.error("Connection commit error", e);
            throw new CustomException(e);
        }
    }

    @Override
    public void rollback() throws CustomException {
        try {
            connection.rollback();
        } catch (SQLException e) {
            LOGGER.error("Connection rollback error", e);
            throw new CustomException(e);
        }
    }

    @Override
    public void setAutoCommit(final boolean isAutoCommit)
            throws CustomException {
        try {
            connection.setAutoCommit(isAutoCommit);
        } catch (SQLException e) {
            LOGGER.error("Set auto commit error", e);
            throw new CustomException(e);
        }
    }
}
