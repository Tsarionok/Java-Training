package by.tsarionok.dao.factory;

import by.tsarionok.dao.Dao;
import by.tsarionok.dao.impl.MatrixDao;

public final class DaoFactory {

    private static final DaoFactory INSTANCE = new DaoFactory();

    private final Dao matrixDao = new MatrixDao();

    private DaoFactory() {
    }

    public static DaoFactory getInstance() {
        return INSTANCE;
    }

    public Dao getMatrixDao() {
        return matrixDao;
    }
}
