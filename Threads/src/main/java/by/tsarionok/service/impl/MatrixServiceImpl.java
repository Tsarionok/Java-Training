package by.tsarionok.service.impl;

import by.tsarionok.dao.Dao;
import by.tsarionok.dao.exception.DaoException;
import by.tsarionok.dao.factory.DaoFactory;
import by.tsarionok.service.MatrixService;
import by.tsarionok.service.exception.ServiceException;
import by.tsarionok.service.filler.impl.FillByExecutorVariant;
import by.tsarionok.service.filler.impl.FillByLockVariant;
import by.tsarionok.service.filler.impl.FillBySemaphoreVariant;
import by.tsarionok.service.filler.impl.FillBySeparateThreadsVariant;
import by.tsarionok.service.validator.Validator;

public class MatrixServiceImpl implements MatrixService {

    private Dao matrixDao;

    private Validator validator;

    public MatrixServiceImpl() {
        DaoFactory factory = DaoFactory.getInstance();
        matrixDao = factory.getMatrixDao();
        validator = new Validator();
    }

    @Override
    public void createMatrix(final String path, final String delimiter) throws ServiceException {
        try {
            if (!validator.isValidValue(path)) {
                throw new ServiceException("The parameters for creating matrix are not valid");
            } else {
                matrixDao.createMatrix(path, delimiter);
            }
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public int[][] fillBySeparateThreads() throws ServiceException {
        try {
            return matrixDao.query(new FillBySeparateThreadsVariant());
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public int[][] fillByLocks() throws ServiceException {
        try {
            return matrixDao
                    .query(new FillByLockVariant());
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public int[][] fillByExecutorService() throws ServiceException {
        try {
            return matrixDao.query(new FillByExecutorVariant());
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public int[][] fillBySemaphore() throws ServiceException {
        try {
            return matrixDao.query(new FillBySemaphoreVariant());
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public void saveLastResult(final String path) throws ServiceException {
        try {
            if (!validator.isValidValue(path)) {
                throw new ServiceException("The parameters for saving  are not valid");
            } else {
                matrixDao.saveLastResult(path);
            }
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }


}
