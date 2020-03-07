package by.tsarionok.dao;

import by.tsarionok.dao.exception.DaoException;
import by.tsarionok.service.filler.Variant;

public interface Dao {

    void createMatrix(String path, String delimiter) throws DaoException;

    int[][] query(Variant variant) throws DaoException;

    void saveLastResult(String path) throws DaoException;
}
