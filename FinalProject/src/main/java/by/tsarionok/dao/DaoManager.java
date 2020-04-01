package by.tsarionok.dao;

import by.tsarionok.exception.CustomException;

public interface DaoManager {
    <T extends Dao<?>> T createAndGetDao(Class<T> key) throws CustomException;

    void commit() throws CustomException;

    void rollback() throws CustomException;

    void setAutoCommit(boolean isAutoCommit) throws CustomException;
}
